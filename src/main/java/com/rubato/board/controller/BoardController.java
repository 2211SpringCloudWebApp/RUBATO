package com.rubato.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.rubato.board.domain.Board;
import com.rubato.board.domain.BoardComment;
import com.rubato.board.domain.PageInfo;
import com.rubato.board.domain.Search;
import com.rubato.board.service.BoardService;
import com.rubato.member.domain.Member;

@Controller
public class BoardController {
	@Autowired
	private BoardService bService;

	// 게시판 작성 화면
	@RequestMapping(value = "/board/write", method = RequestMethod.GET)
	public String writeView() {
		return "board/boardwrite";
	}

	// 게시판 글 등록
	@RequestMapping(value = "/board/write", method = RequestMethod.POST)
	public String boardwrite(@ModelAttribute Board board, HttpServletRequest request, Model model) {
		try {
			// 로그인한 사용자인 경우에만 게시글 등록 가능하도록 처리
			if (request.getSession().getAttribute("loginUser") != null) {
				Member loginUser = (Member) (request.getSession().getAttribute("loginUser"));
				board.setMemberId(loginUser.getMemberId());
				int result = bService.insertBoard(board);
				if (result > 0) {
					return "redirect:/board/list";
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

	// 게시판 수정 view
	@RequestMapping(value = "/board/modify", method = RequestMethod.GET)
	public String boardModifyView(@RequestParam("boardNo") Integer boardNo, 
								  Model model, HttpSession session) {
		try {
			Board board = bService.selectOneByNo(boardNo);
			if(board != null) {
				model.addAttribute("board", board);
				return "board/boardmodify";
			} else {
				model.addAttribute("msg", "데이터 조회에 실패하였습니다.");
				return "common/error";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "common/error";
		}
	}

	// 게시판 수정 logic
	@RequestMapping(value = "/board/modify", method = RequestMethod.POST)
	public String boardModify(@ModelAttribute Board board, Model model) {
		try {
			int result = bService.updateBoard(board);
			if (result > 0) {
				return "redirect:/board/detail?boarNo="+board.getBoardNo();
			} else {
				model.addAttribute("msg", "게시판 수정이 완료되지 않았습니다.");
				return "common/error";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "common/error";
		}
	}

	// 게시판 삭제
	@RequestMapping(value = "/board/remove", method = RequestMethod.GET)
	public String boardRemove(@RequestParam("boardNo") int boardNo, Model model) {
		try {
			int result = bService.deleteBoard(boardNo);
			if (result > 0) {
				return "redirect:/board/list";
			} else {
				model.addAttribute("msg", "게시글이 삭제 되지 않았습니다.");
				return "common/error";
			}
		} catch (Exception e) {
			e.getStackTrace();
			model.addAttribute("msg", "게시글이 삭제 되지 않았습니다.");
			return "common/error";
		}
	}

	// 게시판 목록 조회
	@RequestMapping(value = "/board/list", method = RequestMethod.GET)
	public String boardListView(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
			Model model) {
		int totalCount = bService.getListCount();
		PageInfo pi = this.getPageInfo(page, totalCount);
		List<Board> bList = bService.selectBoardList(pi);
		model.addAttribute("pi", pi);
		model.addAttribute("bList", bList);
		return "board/boardlist";
	}

	// 게시판 목록 네비게이터 시작, 끝값 설정
	private PageInfo getPageInfo(int currentPage, int totalCount) {
		PageInfo pi = null;
		int boardLimit = 10; // 한 페이지 당 게시글 개수
		int naviLimit = 5; // 한 페이지 당 pageNavi 수
		int maxPage; // 페이지의 마지막 번호
		int startNavi; // pageNavi 시작값
		int endNavi; // pageNavi 끝값

		maxPage = (int)((double) totalCount/boardLimit+0.9);
		startNavi = (((int)((double) currentPage/naviLimit+0.9))-1)*naviLimit+1;
		endNavi = startNavi+naviLimit-1;
		if (endNavi > maxPage) {
			endNavi = maxPage;
		}
		pi = new PageInfo(currentPage, boardLimit, naviLimit, startNavi, endNavi, totalCount, maxPage);
		return pi;
	}

	// 게시판 상세화면
	@RequestMapping(value = "/board/detail", method = RequestMethod.GET)
	public String boardDetailView(@RequestParam("boardNo") int boardNo, Model model) {
		try {
			Board board = bService.selectOneByNo(boardNo);
			model.addAttribute("board", board);
			return "board/boarddetail";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "common/error";
		}
	}

	// 게시판 검색기능
	@RequestMapping(value = "/board/search", method = RequestMethod.GET)
	public String boardSearchView(@ModelAttribute Search search,
			@RequestParam(value = "page", required = false, defaultValue = "1") Integer currentPage, Model model) {
		System.out.println(search.getSearchCondition());
		try {
			int totalCount = bService.getListCount(search);
			PageInfo pi = this.getPageInfo(currentPage, totalCount);
			List<Board> searchList = bService.selectListByKeyword(pi, search);
			if (!searchList.isEmpty()) {
				model.addAttribute("search", search);
				model.addAttribute("pi", pi);
				model.addAttribute("sList", searchList);
				model.addAttribute("searchValue", search.getSearchValue()); // 검색 키워드 추가
				return "board/boardsearch";
			} else {
				model.addAttribute("msg", "검색이 되지 않았습니다.");
				return "common/error";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "common/error";
		}
	}
}
