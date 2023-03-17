package com.rubato.market.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.rubato.market.domain.MarketImage;
import com.rubato.market.domain.MarketSell;
import com.rubato.market.domain.PageInfo;
import com.rubato.market.domain.SearchInfo;
import com.rubato.market.service.MarketService;
import com.rubato.member.domain.Member;
import com.rubato.member.service.MemberService;

@Controller
public class MarketController {
	@Autowired
	ServletContext servletContext;  
	
	@Autowired
	private MarketService marketService;
	
	@Autowired
	private MemberService memService;
	
	/*===================================================
	 * 마켓 판매 등록 관련
	 *===================================================*/
	@GetMapping("/market/write")
	public String marketWriteView(HttpSession session, Model model) { // 마켓 판매 페이지 View
		if(session.getAttribute("loginUser")!=null) {
			return "market/marketWrite";
		}
		else {
			model.addAttribute("msg", "로그인 후 이용할 수 있습니다.");
			return "common/error";
		}
	}
	
	
	@PostMapping("/market/write")
	public String marketWriteLogic(@RequestParam("uploadFile") MultipartFile[] uploadFiles, // 마켓 판매글 등록 Logic
									MarketSell marketSell,
									String strPrice,
									HttpSession session,
									Model model) throws IllegalStateException, IOException {
		if(session.getAttribute("loginUser")!=null) {
			String realPath = servletContext.getRealPath("/resources/upload/market");
			String today = new SimpleDateFormat("yyMMdd").format(new Date());
			String savePath = realPath + File.separator + today;
			File folder = new File(savePath);
			if(!folder.exists())
				folder.mkdir();
			
			
			String[] saveFileNames = new String[3];
			int i = 0;
			for(MultipartFile uploadFile : uploadFiles) {
				String originalFileName = uploadFile.getOriginalFilename();
				if(!originalFileName.isEmpty()) {
					saveFileNames[i] = UUID.randomUUID().toString() + originalFileName.substring(originalFileName.lastIndexOf('.'));
					uploadFile.transferTo(new File(folder, saveFileNames[i]));
					i++;
				}
			}
			MarketImage marketImg = new MarketImage();
			marketImg.setImg1(savePath + File.separator + saveFileNames[0]);
			marketImg.setImg2(savePath + File.separator + saveFileNames[1]);
			marketImg.setImg3(savePath + File.separator + saveFileNames[2]);
			int sellPrice = Integer.parseInt(strPrice.replace(",", ""));
			marketSell.setSellPrice(sellPrice);
			String memberId = ((Member) session.getAttribute("loginUser")).getMemberId();
			String memberNickname = ((Member) session.getAttribute("loginUser")).getMemberNickname();
			marketSell.setMemberId(memberId);
			marketSell.setMemberNickname(memberNickname);
			int result = marketService.insertMarketSell(marketImg, marketSell);
			if(result>0) {
				return "redirect:/market/list";
			}
			else {
				return "common/error";
			}
		}
		else {
			return "common/error";
		}
	}
	
	/*===================================================
	 * 마켓 목록
	 *===================================================*/
	@GetMapping("/market/list")
	public String marketListView(SearchInfo searchInfo,
								Model model,
								@RequestParam(value="page", required=false, defaultValue="1") Integer page) { // 게시물 목록 View
		int totalCount = marketService.getTotalCount(searchInfo);
		System.out.println(totalCount);
		PageInfo pi = new PageInfo(page, totalCount);
		List<MarketSell> sellList = marketService.selectAllSell(searchInfo, pi);
		if(!sellList.isEmpty()) {
			model.addAttribute("pi", pi);
			model.addAttribute("searchInfo", searchInfo);
			model.addAttribute("sellList", sellList);
			return "market/marketList";
		}
		else {
			model.addAttribute("msg", "게시물이 존재하지 않습니다.");
			return "market/marketList";
		}
	}
	
	/*===================================================
	 * 마켓 글 상세정보
	 *===================================================*/
	@GetMapping("/market/detail")
	public String marketDetail(@RequestParam(value="sellNo") Integer sellNo, Model model, HttpSession session) {
		MarketSell sell = marketService.selectOneByNo(sellNo);
		String memberId = sell.getMemberId();
		Member seller = memService.selectMemberById(memberId);
		Member loginMember = (Member) session.getAttribute("loginUser");
		if(memberId != "") {
			model.addAttribute("sell", sell);
			model.addAttribute("seller", seller);
			model.addAttribute("loginMember", loginMember);
			return "market/marketDetail";
		}
		else {
			model.addAttribute("msg", "게시물이 존재하지 않습니다.");
			return "common/error";
		}
	}
	
	/*===================================================
	 * 마켓 글 삭제
	 *===================================================*/
	@GetMapping("/market/delete")
	public String marketDelete(@RequestParam(value="sellNo") Integer sellNo, HttpSession session, Model model) {
		if(session.getAttribute("loginUser") != null) {
			String loginMemberId = ((Member) session.getAttribute("loginUser")).getMemberId();
			Map<String, Object> deleter = new HashMap<String, Object>();
			deleter.put("loginMemberId", loginMemberId);
			deleter.put("sellNo", sellNo);
			int result = marketService.deleteMarketSell(deleter);
			if(result>0) {
				return "redirect:/market/list";
			}
			else {
				model.addAttribute("msg", "본인 게시물만 삭제할 수 있습니다.");
				return "common/error";
			}
		}
		else {
			model.addAttribute("msg", "로그인 후 이용할 수 있습니다.");
			return "common/error";
		}
	}

}