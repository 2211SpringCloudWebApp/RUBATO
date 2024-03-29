package com.rubato.lesson.controller;

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

import com.rubato.lesson.domain.Lesson;
import com.rubato.lesson.domain.PageInfo;
import com.rubato.lesson.domain.Search;
import com.rubato.lesson.domain.Apply;
import com.rubato.lesson.service.LessonService;
import com.rubato.member.domain.Member;

@Controller
public class LessonController {
	
	@Autowired
	private LessonService lService;

/*-선생, 레슨 생성-----------------------------------------------------------------*/
	
	/*===================================================
	 * 레슨 등록 View, Logic
	 *===================================================*/
	@RequestMapping(value = "/lesson/create", method = RequestMethod.GET)
	public String createView() { //레슨 등록 View (create.jsp) 
		return "lesson/create";
	}
	
	@RequestMapping(value = "/lesson/create", method = RequestMethod.POST)
	public String createLogic(  //레슨 등록 Logic
			HttpServletRequest request
			, @ModelAttribute Lesson lesson
			, Model model) {
		try {
			HttpSession session = request.getSession();
			if(session.getAttribute("loginUser") != null) {
				String memberId = ((Member)session.getAttribute("loginUser")).getMemberId();
				lesson.setMemberId(memberId);				
				int result = lService.createLesson(lesson);
				if(result > 0) {
					return "redirect:/lesson/list";
				} else {
					model.addAttribute("msg", "레슨글 등록 실패");
					return "common/error";
				}
			} else {
				model.addAttribute("msg", "로그인 후 레슨을 만들 수 있어요.");
				return "common/error";
			}
		} catch (Exception e) {
			model.addAttribute("msg", e.getMessage());
			return "common/error";
		}
	}
	
	/*===================================================
	 * 레슨 삭제 Logic
	 *===================================================*/
	@RequestMapping(value = "/lesson/remove", method = RequestMethod.GET)
	public String removeLessonLogic( // 레슨 삭제 Logic
			@RequestParam("lessonNo") int lessonNo
			, Model model) {
		try {
			int result = lService.removeLesson(lessonNo);
			if(result > 0) {
				return "redirect:/lesson/list";
			} else {
				model.addAttribute("msg", "레슨글 삭제 실패");
				return "common/error";
			}
		} catch (Exception e) {
			model.addAttribute("msg", e.getMessage());
			return "common/error";
		}
		
	}
	
	/*===================================================
	 * 레슨 상세 View
	 *===================================================*/
	@RequestMapping(value = "/lesson/detail", method = RequestMethod.GET)
	public String detailView( // 레슨 상세 View (detail.jsp)
			@RequestParam("lessonNo") Integer lessonNo
			, Model model) {  
		try {
			Lesson lesson = lService.selectOneByNo(lessonNo);
			model.addAttribute("lesson", lesson);
			return "lesson/detail";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "common/error";
		}
	}
	
	/*===================================================
	 * 레슨 수정 View, Logic
	 *===================================================*/
	@RequestMapping(value = "/lesson/modify", method = RequestMethod.GET)
	public String lessonModifyView( //레슨 수정 View (modify.jsp)
			@RequestParam("lessonNo") Integer lessonNo
			, Model model) {
		try {
			Lesson lesson = lService.selectOneByNo(lessonNo);
			if(lesson != null) {
				model.addAttribute("lesson", lesson);
				return "lesson/modify";
			} else {
				model.addAttribute("msg", "레슨 조회 실패");
				return "common/error";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "common/error";
		}
	}
	
	@RequestMapping(value = "/lesson/modify", method = RequestMethod.POST)
	public String lessonModifyLogic( // 레슨 수정 Logic
			@ModelAttribute Lesson lesson
			, Model model) {
		try {
			int result = lService.modifyLesson(lesson);
			if(result > 0 ) {
				return "redirect:/lesson/detail?lessonNo="+lesson.getLessonNo();
			} else {
				model.addAttribute("msg", "레슨 수정 실패");
				return "common/error";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "common/error";
		}		
	}
	
	/*===================================================
	 * 레슨 목록 전체 View
	 *===================================================*/
	@RequestMapping(value = "/lesson/list", method = RequestMethod.GET)
	public String listView( // 레슨 목록 View (list.jsp)
			@RequestParam(value = "page", required = false, defaultValue = "1") Integer page
			, Model model) { 
		try {
			int totalCount = lService.getListCount();
			PageInfo pi = getPageInfo(page, totalCount);
			List<Lesson> lList = lService.selectLessons(pi);
			if(!lList.isEmpty()) {
				model.addAttribute("lList", lList);
				model.addAttribute("pi", pi);
				return "lesson/list";
			} else {
				model.addAttribute("msg", "생성레슨이 없어요. 레슨을 만들어 루바토의 선생님이 되어보세요!");
				return "common/error";
			}
		} catch (Exception e) {
			model.addAttribute("msg", e.getMessage());
			return "common/error";
		}
	}
	
	/*===================================================
	 * 나의 레슨 목록 View
	 *===================================================*/
	@RequestMapping(value = "/lesson/mylesson", method = RequestMethod.GET)
	public String myLessonView(
			HttpServletRequest request
			, @RequestParam(value="page", required=false, defaultValue="1") Integer page
			, Model model) {
		try {
			HttpSession session = request.getSession();
			String memberId = ((Member)session.getAttribute("loginUser")).getMemberId();
			int totalCount = lService.getListCount(memberId);
			PageInfo pi = getPageInfo(page, totalCount);
			List<Lesson> lList = lService.selectMyLessons(memberId, pi);
			if(!lList.isEmpty()) {
				model.addAttribute("lList", lList);
				model.addAttribute("memberId", memberId);
				model.addAttribute("pi", pi);
				return "/lesson/mylesson";
			} else {
				model.addAttribute("msg", "레슨 내역이 없어요");
				return "common/error";
			}
		} catch (Exception e) {
			model.addAttribute("msg", e.getMessage());
			return "common/error";
		}
	}

	/*===================================================
	 * 레슨 검색
	 *===================================================*/
	@RequestMapping(value = "/lesson/search", method = RequestMethod.GET)
	public String lessonSearchView(
			@ModelAttribute Search search
			, @RequestParam(value = "page", required = false, defaultValue = "1") Integer currentPage
			, Model model) {
		try {
			int totalCount = lService.getListCount(search);
			PageInfo pi = this.getPageInfo(currentPage, totalCount);
			List<Lesson> searchList = lService.selectListByKeyword(pi, search);
			if(!searchList.isEmpty()) {
				model.addAttribute("search", search);
				model.addAttribute("pi", pi);
				model.addAttribute("sList", searchList);
				return "lesson/search";
			} else {
				model.addAttribute("msg", "검색된 결과가 없습니다.");
				return "common/error";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "common/error";
		}
	}
	
	
	
	
/*-학생, 레슨 신청-----------------------------------------------------------------*/
	
	/*===================================================
	 * 신청글 작성 View, Logic
	 *===================================================*/
	@RequestMapping(value = "/apply/create", method = RequestMethod.GET)
	public String applyView(  //레슨 신청 View (apply.jsp)
			@RequestParam("lessonNo") int lessonNo
			, Model model) { 
		Lesson lesson = lService.selectOneByNo(lessonNo);
		model.addAttribute("lesson", lesson);
		return "apply/create";
	}
	
	@RequestMapping(value = "/apply/create", method = RequestMethod.POST)
	public String applyLogic(   //레슨 신청 Logic
			HttpServletRequest request
			, @ModelAttribute Apply apply
			, Model model) {
		try {
			HttpSession session = request.getSession();
			if(session.getAttribute("loginUser") != null) {
				String memberId =((Member)session.getAttribute("loginUser")).getMemberId();
				apply.setMemberId(memberId);
				Apply check = lService.selectOneApply(apply);
				if(check == null ) {
					int result = lService.createApply(apply);
					if(result > 0) {
						return "redirect:/apply/myapply";
					} else {
						model.addAttribute("msg", "레슨글 등록 오류. 다시 시도해주세요!");
						return "common/error";
					}
				} else {
					model.addAttribute("msg", "레슨 당 한번만 신청 가능합니다.");
					return "common/error";
				}			
			} else {
				model.addAttribute("msg", "로그인이 필요한 기능입니다");
				return "common/error";
			}
		} catch (Exception e) {
			System.out.println(apply.toString());
			model.addAttribute("msg", e.getMessage());
			return "common/error";
		}
	}

	/*===================================================
	 * 신청글 삭제 Logic
	 *===================================================*/
	@RequestMapping(value = "/apply/remove", method = RequestMethod.GET)
	public String removeApplyLogic( //신청글 삭제 Logic
			@RequestParam("lessonNo") int lessonNo
			, HttpServletRequest request
			, Model model ) {
		try {
			HttpSession session = request.getSession();
			String memberId =((Member)session.getAttribute("loginUser")).getMemberId();
			Apply apply = new Apply(lessonNo, memberId);
			int result = lService.removeApply(apply);
			if(result > 0) {
				return "redirect:/apply/myapply";
			} else {
				model.addAttribute("msg", "신청글 삭제 실패");
				return "common/error";
			}
		} catch (Exception e) {
			model.addAttribute("msg", e.getMessage());
			return "common/error";
		}
	}
	
	/*===================================================
	 * 신청글 수정 View, Logic
	 *===================================================*/
	@RequestMapping(value = "/apply/modify", method = RequestMethod.GET)
	public String applyModifyView( // 신청글 수정 View
			@RequestParam("lessonNo") int lessonNo
			, HttpServletRequest request
			, Model model) {
		try {
			HttpSession session = request.getSession();
			String memberId =((Member)session.getAttribute("loginUser")).getMemberId();
			Apply apply = new Apply(lessonNo, memberId);
			Apply apply2 = lService.selectOneApply(apply);
			if(apply2 != null) {
				model.addAttribute("apply", apply2);
				return "apply/modify";
			} else {
				model.addAttribute("msg", "신청글 수정 실패");
				return "common/error";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "common/error";
		}
	}
	
	@RequestMapping(value = "/apply/modify", method = RequestMethod.POST)
	public String applyModifyLogic( // 신청글 수정 Logic
			@ModelAttribute Apply apply
			, HttpServletRequest request
			, Model model) {
		try {
			HttpSession session = request.getSession();
			String memberId =((Member)session.getAttribute("loginUser")).getMemberId();
			apply.setMemberId(memberId);
			int result = lService.modifyApply(apply);
			if(result > 0) {
				return "redirect:/apply/myapply";
			} else {
				model.addAttribute("msg", "신청 수정 실패");
				return "common/error";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "common/error";
		}
	}
	
	
	/*===================================================
	 * 나의 신청글 목록 View
	 *===================================================*/
	@RequestMapping(value = "/apply/myapply", method = RequestMethod.GET)
	public String applyListView(
			HttpServletRequest request
			, @RequestParam(value="page", required=false, defaultValue="1") Integer page
			, Model model) {
		try {
			HttpSession session = request.getSession();
			String memberId = ((Member)session.getAttribute("loginUser")).getMemberId();
			int totalCount = lService.getApplyCount(memberId);
			PageInfo pi = getPageInfo(page, totalCount);
			List<Apply> aList = lService.selectApplys(memberId, pi);
			if(!aList.isEmpty()) {
				model.addAttribute("aList", aList);
				model.addAttribute("memberId", memberId);
				model.addAttribute("pi", pi);
				return "apply/myapply";
			} else {
				model.addAttribute("msg", "레슨 신청 내역이 없어요");
				return "common/error";
			}
		} catch (Exception e) {
			model.addAttribute("msg", e.getMessage());
			return "common/error";
		}
	}

	/*===================================================
	 * 레슨별 신청글 목록 View
	 *===================================================*/
	@RequestMapping(value = "/apply/listbylesson", method = RequestMethod.GET)
	public String applyByLesson( // 레슨별 신청 목록 View (listbylesson.jsp)
			@RequestParam("lessonNo") int lessonNo
			, @RequestParam(value="page", required=false, defaultValue="1") Integer page
			, Model model) {
		try {
			int totalCount = lService.getListCount(lessonNo);
			PageInfo pi = getPageInfo(page, totalCount);
			List<Apply> aList = lService.selectByLesson(lessonNo, pi);
			if(!aList.isEmpty()) {
				model.addAttribute("aList", aList);
				model.addAttribute("lessonNo", lessonNo);
				model.addAttribute("pi", pi);
				return "apply/listbylesson";
			} else {
				model.addAttribute("msg", "해당 레슨에 받은 신청이 없어요.");
				return "common/error";
			}
		} catch (Exception e) {
			model.addAttribute("msg", e.getMessage());
			return "common/error";
		}
	}
	
	
	/*===================================================
	 * 페이징
	 *===================================================*/
	private PageInfo getPageInfo(int currentPage, int totalCount) {
		PageInfo pi = null;
		int boardLimit = 10;
		int naviLimit = 5;
		int maxPage;
		int startNavi;
		int endNavi;
		
		maxPage = (int)((double)totalCount/boardLimit+0.9);
		startNavi = (((int)((double)currentPage/naviLimit+0.9))-1)*naviLimit+1;
		endNavi = startNavi + naviLimit - 1;
		if(endNavi > maxPage) {
			endNavi = maxPage;
		}
		pi = new PageInfo(currentPage, boardLimit, naviLimit, startNavi, endNavi, totalCount, maxPage);
		return pi;
	}
	
	
	
	
	
	
	
	
	
}
