package com.rubato.market.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.rubato.market.service.MarketService;
import com.rubato.member.domain.Member;

@Controller
public class MarketController {
	@Autowired
	ServletContext servletContext;  
	
	@Autowired
	private MarketService marketService;
	
	/*===================================================
	 * 마켓 판매 등록 관련
	 *===================================================*/
	@GetMapping("/market/write")
	public String marketWriteView(HttpSession session) { // 마켓 판매 페이지 View
		if(session.getAttribute("loginUser")!=null) {
			return "market/marketWrite";
		}
		else {
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
			marketSell.setMemberId(memberId);
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

}
