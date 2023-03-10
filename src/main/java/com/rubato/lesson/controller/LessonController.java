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
			Member member = new Member(); //삭제필
			member.setMemberId("음악조아"); //삭제필
			HttpSession session = request.getSession(); //세션 아이디 가져오기
			session.setAttribute("member", member); //삭제필
			if(session != null) {
				String memberId = ((Member)session.getAttribute("member")).getMemberId();
				lesson.setMemberId(memberId);				
			} else {
				model.addAttribute("msg", "로그인 후 레슨을 만들 수 있어요.");
				return "common/error";
			}
			int result = lService.createLesson(lesson);
			if(result > 0) {
				return "redirect:/lesson/list";
			} else {
				model.addAttribute("msg", "레슨글 등록 실패");
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
			@RequestParam("lessonNo") int lessonNo
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
	 * 레슨 목록 View
	 *===================================================*/
	@RequestMapping(value = "/lesson/list", method = RequestMethod.GET)
	public String listView( // 레슨 목록 View (list.jsp)
			Model model) { 
		try {
			List<Lesson> lList = lService.selectLessons();
			if(!lList.isEmpty()) {
				model.addAttribute("lList", lList);
				return "lesson/list";
			} else {
				model.addAttribute("msg", "텅");
				return "common/error";
			}
		} catch (Exception e) {
			model.addAttribute("msg", e.getMessage());
			return "common/error";
		}
	}
	
	
/*-학생, 레슨 신청-----------------------------------------------------------------*/
	
	/*===================================================
	 * 신청글 작성 View, Logic
	 *===================================================*/
	@RequestMapping(value = "/apply/create", method = RequestMethod.GET)
	public String applyView(
			@RequestParam("lessonNo") int lessonNo
			, Model model) {  //레슨 신청 View (apply.jsp)
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
				int result = lService.createApply(apply);
				if(result > 0) {
					return "apply/myapply";
				} else {
					model.addAttribute("msg", "레슨글 등록 실패");
					return "common/error";
				}
			} else {
				model.addAttribute("msg", "로그인이 필요한 기능입니다");
				return "common/error";
			}
		} catch (Exception e) {
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
	 * 신청글 목록 View
	 *===================================================*/
	@RequestMapping(value = "/apply/myapply", method = RequestMethod.GET)
	public String applyListView(
			HttpServletRequest request
			, Model model) {
		try {
			HttpSession session = request.getSession();
			String memberId =((Member)session.getAttribute("loginUser")).getMemberId();
			//레슨 타이틀 가져오기
			List<Apply> aList = lService.selectApplys(memberId);
			model.addAttribute("aList", aList);
			if(!aList.isEmpty()) {
				return "apply/myapply";
			} else {
				model.addAttribute("msg", "신청 내역이 없어요");
				return "common/error";
			}
		} catch (Exception e) {
			model.addAttribute("msg", e.getMessage());
			return "common/error";
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}