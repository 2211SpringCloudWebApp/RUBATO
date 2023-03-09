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
import com.rubato.lesson.service.LessonService;
import com.rubato.member.domain.Member;

@Controller
public class LessonController {
	
	@Autowired
	private LessonService lService;
	
	/*===================================================
	 * 레슨 등록 View, Logic
	 *===================================================*/
	@RequestMapping(value = "/lesson/create", method = RequestMethod.GET)
	public String createView() { // 레슨 등록 View (create.jsp) 
		return "lesson/create";
	}
	
	@RequestMapping(value = "/lesson/create", method = RequestMethod.POST)
	public String createLogic( //레슨 등록 Logic
			HttpServletRequest request
			, @ModelAttribute Lesson lesson
			, Model model) {
		try {
			Member member = new Member(); //
			member.setMemberId("음악조아"); //
			HttpSession session = request.getSession();
			session.setAttribute("member", member); //
			if(session != null) {
				String memberId = ((Member)session.getAttribute("member")).getMemberId();
				lesson.setMemberId(memberId);
				
				System.out.println(lesson.toString());
				
			} 
//			else {
//				model.addAttribute("msg", "로그인 후 레슨을 만들 수 있어요.");
//				return "common/error";
//			}
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
	
	
	
	
	
	// 레슨 신청 화면 (apply.jsp) 보이게 하는 메소드
	@RequestMapping(value = "/lesson/apply", method = RequestMethod.GET)
	public String applyView() {
		return "lesson/apply";
	}
	

	
	
	
}
