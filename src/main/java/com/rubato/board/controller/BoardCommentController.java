package com.rubato.board.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rubato.board.domain.BoardComment;
import com.rubato.board.service.BoardCommentService;

@Controller
public class BoardCommentController {
	@Autowired
	private BoardCommentService boardCommentService;
	@Autowired
	private HttpSession httpSession;

	// 댓글 작성
	@PostMapping("/boarddetail/boardcomment")
	@ResponseBody
	public String insertComment(int commentNo, HttpSession session) {
		// 로그인 하지 않은 경우 로그인 페이지로 이동
		if (session.getAttribute("memberId") == null) {
			return "redirect:login";
		} else {
			// 로그인한 사용자만 댓글 작성 가능
			boardCommentService.insertComment(commentNo);
			return "redirect:board/detail";
		}
	}

	// 댓글 삭제
	@DeleteMapping("/boardComment/{commentNo}")
	@ResponseBody
	public String deleteComment(@PathVariable("commentNo") int commentNo, Model model) {
		try {
			int result = boardCommentService.insertComment(commentNo);
			if (result > 0) {
				boardCommentService.deleteComment(commentNo);
				return "redirect:/board/detail";
			} else {
				model.addAttribute("msg", "댓글이 삭제 되지 않았습니다.");
				return "common/error";
			}
		} catch (Exception e) {
			e.getStackTrace();
			model.addAttribute("msg", "댓글이 삭제 되지 않았습니다.");
			return "common/error";
		}
	}
}
