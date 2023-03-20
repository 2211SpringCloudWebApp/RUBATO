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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.rubato.market.domain.MarketComment;
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
	public String marketDetail(@RequestParam(value="sellNo") Integer sellNo, Model model, HttpSession session,
											@RequestParam(value="page", required=false, defaultValue="1") Integer page) {
		int result = marketService.updateViewCount(sellNo);
		if(result>0) { //조회수 증가 =>  게시물 존재
			int totalCount = marketService.getCmtTotalCount(sellNo);
			PageInfo pi = new PageInfo(page, totalCount);
			Map<String, Object> commentMap = new HashMap<String, Object>();
			commentMap.put("sellNo", sellNo);
			commentMap.put("pi", pi);
			List<MarketComment> commentList = marketService.selectAllComment(commentMap);
			MarketSell sell = marketService.selectOneByNo(sellNo);
			String memberId = sell.getMemberId();
			Member seller = memService.selectMemberById(memberId);
			Member loginMember = (Member) session.getAttribute("loginUser");
			if(memberId != "") {
				model.addAttribute("sell", sell);
				model.addAttribute("seller", seller);
				model.addAttribute("loginMember", loginMember);
				model.addAttribute("commentList", commentList);
				model.addAttribute("commentCount", totalCount);
				model.addAttribute("pi", pi);
				return "market/marketDetail";
			}
			else {
				model.addAttribute("msg", "게시물이 존재하지 않습니다.");
				return "common/error";
			}
		}
		else {
			model.addAttribute("msg", "게시물이 존재하지 않습니다.");
			return "common/error";
		}
	}
	
	/*===================================================
	 * 마켓 글 수정
	 *===================================================*/
	@GetMapping("/market/modify")
	public String marketModify(@RequestParam(value="sellNo") Integer sellNo, HttpSession session, Model model) {
		if(session.getAttribute("loginUser") != null) {
			MarketSell sell = marketService.selectOneByNo(sellNo);
			String writerId = sell.getMemberId();
			String loginMemberId = ((Member) session.getAttribute("loginUser")).getMemberId();
			Map<String, Object> writer = new HashMap<String, Object>();
			writer.put("sellNo", sellNo);
			writer.put("loginMemberId", loginMemberId);
			if(sell!=null && writerId.equals(loginMemberId)) {
				model.addAttribute("sell", sell);
				return "market/marketModify";
			}
			else {
				model.addAttribute("msg", "본인 게시물만 수정할 수 있습니다.");
				return "common/error";
			}
		}
		else {
			model.addAttribute("msg", "로그인 후 이용할 수 있습니다.");
			return "common/error";
		}
	}
	
	@PostMapping("/market/modify")
	public String marketModify(@RequestParam("uploadFile") MultipartFile[] uploadFiles,
								@RequestParam(value="sellNo") Integer sellNo,
								MarketSell marketSell,
								String strPrice,
								HttpSession session,
								Model model) throws IllegalStateException, IOException {
		//기존 존재하는 이미지 파일 전부 삭제
		int result = marketService.deleteMarketImage(sellNo);
		if(result>0) {
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
				marketSell.setSellNo(sellNo);
				result = marketService.updateMarketSell(marketImg, marketSell);
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
		else { //이미지 삭제 실패
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
	
	/*===================================================
	 * 마켓 구매 신청 (결제)
	 *===================================================*/
	// 결제창 View
	@GetMapping("/market/payment")
	public String marketPayment(@RequestParam(value="sellNo") Integer sellNo, HttpSession session, Model model) {
		Member loginMember = (Member) session.getAttribute("loginUser");
		MarketSell sell = marketService.selectOneByNo(sellNo);
		if(loginMember!=null && sell.getSellCondition().equals("selling")) {
			model.addAttribute("sell", sell);
			return "market/marketBuy";
		}
		else if(sell.getSellCondition().equals("soldout")) {
			model.addAttribute("msg", "이미 판매 완료된 상품입니다.");
			return "common/error";
		}
		else {
			model.addAttribute("msg", "로그인 후 이용할 수 있습니다.");
			return "common/error";
		}
	}
	
	// 결제완료
	@PostMapping("/market/payment")
	@ResponseBody
	public String marketPayment(@RequestBody Map<String, Object> map) {
		int sellNo = Integer.parseInt(String.valueOf(map.get("sellNo")));
		String sellerId = ((MarketSell) marketService.selectOneByNo(sellNo)).getMemberId();
		map.put("sellerId", sellerId); //판매자ID를 여기서 저장하도록 할것.
//		String sellTitle = (String) map.get("sellTitle");
		int paymentPrice = Integer.parseInt(String.valueOf(map.get("paymentPrice")));
		Map<String, Object> seller = new HashMap<String, Object>();
		seller.put("sellerId", sellerId);
		seller.put("paymentPrice", paymentPrice);
//		String buyerId = (String) map.get("buyerId");
//		String deliveryMsg = (String) map.get("deliveryMsg");
		int result = marketService.insertMarketPayment(map);
		if(result>0) {
			result = 0;
			result = marketService.updateSellCondition(sellNo);
			if(result>0) {
				result = 0;
				result = marketService.updateMemberPoint(seller);
				if(result>0) {
					return "true";
				}
				else {
					return "false";
				}
			}
			else {
				return "false";
			}
		}
		else {
			return "false";
		}
	}
	
	/*===================================================
	 * 판매글 댓글 관련
	 *===================================================*/
	// 댓글 작성
	@PostMapping("/market/detail/comment")
	@ResponseBody
	public String marketComment(@RequestBody Map<String, Object> map, HttpSession session) {
		if(session.getAttribute("loginUser") != null) {
			int sellNo = Double.valueOf(String.valueOf(map.get("sellNo"))).intValue();
			String commentContent = (String) map.get("commentContent");
			String memberId = ((Member) session.getAttribute("loginUser")).getMemberId();
			Map<String, Object> comment = new HashMap<String, Object>();
			comment.put("sellNo", sellNo);
			comment.put("memberId", memberId);
			comment.put("commentContent", commentContent);
			int result = marketService.insertComment(comment);
			if(result>0) {
				return "true";
			}
			else {
				return "false";
			}
		}
		else {
			return "false";
		}
	}
	
	// 댓글 삭제
	@PostMapping("/market/detail/comment/delete")
	@ResponseBody
	public String marketCommentDelete(@RequestBody Map<String, Object> map, HttpSession session) {
		if(session.getAttribute("loginUser") != null) {
			int sellNo = Double.valueOf(String.valueOf(map.get("sellNo"))).intValue();
			int commentNo = Double.valueOf(String.valueOf(map.get("commentNo"))).intValue();
			String memberId = ((Member) session.getAttribute("loginUser")).getMemberId();
			Map<String, Object> comment = new HashMap<String, Object>();
			comment.put("sellNo", sellNo);
			comment.put("commentNo", commentNo);
			comment.put("memberId", memberId);
			int result = marketService.deleteComment(comment);
			if(result>0) {
				return "true";
			}
			else {
				return "false";
			}
		}
		else {
			return "false";
		}
	}

	// 댓글 수정
	@PostMapping("/market/detail/comment/modify")
	@ResponseBody
	public String marketCommentModify(@RequestBody Map<String, Object> map, HttpSession session) {
		if(session.getAttribute("loginUser") != null) {
			int commentNo = Double.valueOf(String.valueOf(map.get("commentNo"))).intValue();
			String commentContent = (String) map.get("commentContent");
			String memberId = ((Member) session.getAttribute("loginUser")).getMemberId();
			Map<String, Object> comment = new HashMap<String, Object>();
			comment.put("commentNo", commentNo);
			comment.put("commentContent", commentContent);
			comment.put("memberId", memberId);
			int result = marketService.updateComment(comment);
			if(result>0) {
				return "true";
			}
			else {
				return "false";
			}
		}
		else {
			return "false";
		}
	}
	
}