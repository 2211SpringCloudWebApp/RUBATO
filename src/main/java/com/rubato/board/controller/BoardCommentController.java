package com.rubato.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.rubato.board.domain.Board;
import com.rubato.board.domain.BoardComment;
import com.rubato.board.service.BoardCommentService;
import com.rubato.member.domain.Member;

@Controller
public class BoardCommentController {
	@Autowired
	private BoardCommentService bcService;
	@Autowired
	private HttpSession httpSession;

	// 댓글 목록
	@RequestMapping(value = "/boradcomment/bcList", method = RequestMethod.GET)
	public String boardCommentListView(@PathVariable("boardNo") int boardNo, Model model) {
		List<BoardComment> bcList = bcService.selectCommentList(boardNo);
		model.addAttribute("bcList", bcList);
		return "board/baorddetail";
	}
	// 댓글 작성 화면
	@RequestMapping(value="/board/comment", method=RequestMethod.GET)
	public String insertCommentView() {
		return "board/boarddetail";
	}

	// 댓글 작성
	@PostMapping("/board/comment")
	public String insertComment(@ModelAttribute BoardComment boardComment, 
								@RequestParam("boardNo") Integer boardNo,
								@RequestParam("commentContent") String commentContent, 
								HttpServletRequest request, 
								Model model) {
		try {
			// 로그인한 사용자만 댓글 등록이 가능하도록 처리
			if (request.getSession().getAttribute("loginUser") != null) {
				Member loginUser = (Member) (request.getSession().getAttribute("loginUser"));
				 boardComment.setBoardNo(boardNo);
		         boardComment.setCommentContent(commentContent);
		         boardComment.setMemberId(loginUser.getMemberId());
	
				int result = bcService.insertComment(boardComment);
				if(result > 0) {
					return "redirect:/board/detail?boardNo="+boardNo;
				} else {
					model.addAttribute("msg", "게시글 등록이 되지 않았습니다.");
					return "common/error";
				}
			} else {
				model.addAttribute("msg", "로그인 후에 이용해주세요.");
				return "common/error";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "common/error";
		}
	}

	// 댓글 삭제
	@DeleteMapping("/boardComment/{commentNo}")
	public String deleteComment(@PathVariable("commentNo") int commentNo, Model model) {
		try {
			int result = bcService.deleteComment(commentNo);
			if (result > 0) {
				bcService.deleteComment(commentNo);
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
