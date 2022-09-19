package com.kindergarten.hi.lessons.controller;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.kindergarten.hi.common.paging.Pagenation;
import com.kindergarten.hi.common.paging.SelectCriteria;
import com.kindergarten.hi.lessons.model.dto.ClassKindDTO;
import com.kindergarten.hi.lessons.model.dto.LesEmployeeDTO;
import com.kindergarten.hi.lessons.model.dto.LessonsPlanDTO;
import com.kindergarten.hi.lessons.model.dto.LessonsReportDTO;
import com.kindergarten.hi.lessons.model.dto.TimeTableDTO;
import com.kindergarten.hi.lessons.model.service.LessonsService;
import com.kindergarten.hi.login.model.dto.UserImpl;



@Controller
@RequestMapping("/lessons")
public class LessonsController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	private final LessonsService lessonsService;
	
	@Autowired
	public LessonsController(LessonsService lessonsService) {
		this.lessonsService = lessonsService;
	}
	
	// 수업계획서 경로이동
	@GetMapping("/plan")
    public String goPlan() {
		return "lessons/plan";
    }
	// 결재 수업계획서 경로이동
	@GetMapping("/paymentPlan")
    public String goPaymentPlan(@AuthenticationPrincipal UserImpl user, RedirectAttributes rttr) {
		
		 int status = user.getLoginEmployeeRoleList().get(0).getAuthorityCode(); //권한조회

		
	        if(status !=3) {
	        	rttr.addFlashAttribute("message","권한이 없습니다.");
	        	
	       return "redirect:/";
	        }else {
	        return "payment/plan";}
    }
	
	// 수업계획서 등록
	@GetMapping("/plan/register")
    public String goPlanReg() {
        return "lessons/planreg";
    }
	
	// 수업계획서 상세조회
	@GetMapping("/plan/detail")
    public ModelAndView goPlanDetail(@RequestParam String param, ModelAndView mv) {
		
		LessonsPlanDTO data = lessonsService.planDetail(param);
		
		mv.addObject("data", data);
		mv.setViewName("lessons/plandetail");
		
        return mv;
    }
	
	// 수업계획서 상세조회
		@GetMapping("/plan/detailPy")
	    public ModelAndView goPlanDetailPy(@RequestParam String param, ModelAndView mv) {
			
			LessonsPlanDTO data = lessonsService.planDetail(param);
			
			mv.addObject("data", data);
			mv.setViewName("payment/plandetail");
			
	        return mv;
	    }
		
		// 수업계획서 반려,승인
		@GetMapping("/plan/modifyPy")
	    public String goPlanModifyPy(HttpServletRequest request, RedirectAttributes rttr) {
			
			int no =  Integer.parseInt(request.getParameter("param"));
			String check = request.getParameter("yN");
			String yN = null;
			
			if(check.equals("Y")) {
				yN = "승인";
			}else if(check.equals("N")){
				yN = "반려";
			}
			
			lessonsService.updatePlanPy(no,yN);
			
	        return "redirect:/lessons/paymentPlan";
	    }
	
	// 수업계획서 수정
	@GetMapping("/plan/modify")
    public ModelAndView goPlanModify(@RequestParam String param, ModelAndView mv) {
		
		LessonsPlanDTO data = lessonsService.planDetail(param);
		List<LesEmployeeDTO> empList = lessonsService.PlanRegCategoryEmp();
		List<ClassKindDTO> ckList = lessonsService.PlanRegCategoryCk();
		
		mv.addObject("data", data);
		mv.addObject("empList", empList);
		mv.addObject("ckList", ckList);
		mv.setViewName("lessons/planmod");
		
        return mv;
    }
	
	// 결제단에서 수업계획서 삭제
	@GetMapping("/plan/deletePy")
	public String planDeletePy(@RequestParam String param, RedirectAttributes rttr) {
		
		int result = lessonsService.planDelete(param);
		
		String message = "";
		
		if(result > 0) {
			message = "삭제에 성공하였습니다.";
		} else {
			message = "삭제에 실패하였습니다.";
		} 
	
		rttr.addFlashAttribute("message", message);
		return "redirect:/lessons/paymentPlan";
	}
		
	@GetMapping("/report/modify")
    public ModelAndView goReportModify(@RequestParam String param, ModelAndView mv) {
		
		LessonsReportDTO data = lessonsService.reportDetail(param);
		List<LesEmployeeDTO> empList = lessonsService.PlanRegCategoryEmp();
		List<ClassKindDTO> ckList = lessonsService.PlanRegCategoryCk();
		
		mv.addObject("data", data);
		mv.addObject("empList", empList);
		mv.addObject("ckList", ckList);
		mv.setViewName("lessons/reportmod");
		
        return mv;
    }

	
	// 수업계획서 삭제
	@GetMapping("/plan/delete")
	public String planDelete(@RequestParam String param, RedirectAttributes rttr) {
		
		int result = lessonsService.planDelete(param);
		
		String message = "";
		
		if(result > 0) {
			message = "삭제에 성공하였습니다.";
		} else {
			message = "삭제에 실패하였습니다.";
		} 
	
		rttr.addFlashAttribute("message", message);
		return "redirect:/lessons/plan";
	}
	
	// 수업계획서 제출
	@GetMapping("/plan/submit")
	public String planSubmit(@RequestParam String param, RedirectAttributes rttr) {
		
		int result = lessonsService.planSubmit(param);
		
		String message = "";
		
		if(result > 0) {
			message = "제출에 성공하였습니다.";
		} else {
			message = "제출에 실패하였습니다.";
		} 
	
		rttr.addFlashAttribute("message", message);
		return "redirect:/lessons/plan";
	}
	
	@GetMapping("/report/submit")
	public String reportSubmit(@RequestParam String param, RedirectAttributes rttr) {
		
		int result = lessonsService.reportSubmit(param);
		
		String message = "";
		
		if(result > 0) {
			message = "제출에 성공하였습니다.";
		} else {
			message = "제출에 실패하였습니다.";
		} 
	
		rttr.addFlashAttribute("message", message);
		return "redirect:/lessons/report";
	}
	
	// 수업보고서 경로이동
	@GetMapping("/report")
    public String goReport() {
        return "lessons/report";
    }
	
	// 수업보고서 상세보기
	@GetMapping("/report/detail")
    public String goReportDetail() {
        return "lessons/reportdetail";
    }
	
	// 시간표 달력 경로이동
	@GetMapping("/timetablecalendar")
    public String goTimeTableCalendar() {
        return "lessons/timetablecalendar";
    }
	
	// 시간표 상세보기
	@GetMapping("/timetable")
    public ModelAndView goTimeTable(@RequestParam String param, ModelAndView mv) {
		
		LessonsPlanDTO plan = lessonsService.planDetail(param);
		List<LesEmployeeDTO> empList = lessonsService.PlanRegCategoryEmp();
		
		System.out.println("plan > " + plan);
		
		mv.addObject("plan", plan);
		mv.addObject("empList", empList);
		mv.setViewName("lessons/timetable");
	
        return mv;
    }
	
	@GetMapping("/timetable/submit")
	public String timetableSubmit(HttpServletRequest request, RedirectAttributes rttr) {
		System.out.println("timetableSubmit");
		String lpIdx = request.getParameter("lpIdx");
		String classIdx = request.getParameter("classIdx");
		String mainTeacher = request.getParameter("mainTeacher");
		String age = request.getParameter("age");
		String resDate = request.getParameter("resDate");
		String ttlNum = request.getParameter("ttlNum");
		
		Map<String, Object> hm = new HashMap<>();
		
		hm.put("lpIdx", lpIdx);
		hm.put("classIdx", classIdx);
		hm.put("mainTeacher", mainTeacher);
		hm.put("age", age);
		hm.put("resDate", resDate);
		hm.put("ttlNum", ttlNum);
		System.out.println("ma > " + mainTeacher);
		int result = lessonsService.timeTableSubmit(hm);
		
		String message = "";
		
		if(result > 0) {
			message = "제출에 성공하였습니다.";
		} else {
			message = "제출에 실패하였습니다.";
		} 
	
		rttr.addFlashAttribute("message", message);
		return "redirect:/lessons/timetablecalendar";
		
	}
	
	@PostMapping(value="/timetable/select", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String timetableSelect(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String param = (String) request.getParameter("param");
		List<TimeTableDTO> list = lessonsService.timeTableSelect(param);
		List<LesEmployeeDTO> empList = lessonsService.PlanRegCategoryEmp();
		
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		
		JsonObject jsonObject = new JsonObject();
		String str_list = gson.toJson(list);
		String str_empList = gson.toJson(empList);
		
		jsonObject.addProperty("list", str_list);
		jsonObject.addProperty("empList", str_empList);
		
		String data = gson.toJson(jsonObject);
		
		return data;
	}
	
	// 결재 수업계획서 ajax 리스트 조회
	@GetMapping(value="/plan/selectPaymentList", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String planselectPaymentList(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String startDate = (String) request.getParameter("startDate");
		String endDate = (String) request.getParameter("endDate");
		String selectVal = (String) request.getParameter("selectVal");
		String searchVal = (String) request.getParameter("searchVal");
		
		String currentPage = request.getParameter("currentPage");
        int pageNo = 1;

        if(currentPage != null && !"".equals(currentPage)) {
            pageNo = Integer.parseInt(currentPage);
        }
		
		Map<String, Object> hm = new HashMap<>();
		
		hm.put("startDate", startDate);
		hm.put("endDate", endDate);
		hm.put("selectVal", selectVal);
		hm.put("searchVal", searchVal);
		
//			int totalCount = lessonsService.planSelectTotalCount(hm);
		int totalCount = lessonsService.planSelectTotalCountPy(hm);
		
		log.info("totalBoardCount : " + totalCount);
		
		/* 한 페이지에 보여 줄 게시물 수 */
        int limit = 10;		//얘도 파라미터로 전달받아도 된다.

        /* 한 번에 보여질 페이징 버튼의 갯수 */
        int buttonAmount = 5;

        /* 페이징 처리를 위한 로직 호출 후 페이징 처리에 관한 정보를 담고 있는 인스턴스를 반환받는다. */
        SelectCriteria selectCriteria = null;
        
        selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount);
        
        hm.put("startRow", selectCriteria.getStartRow());
        hm.put("endRow", selectCriteria.getEndRow());
        hm.put("limit", limit);
        
        System.out.println("hm : "+hm);
        
//			List<LessonsPlanDTO> list = lessonsService.planSelectList(hm);
        List<LessonsPlanDTO> list = lessonsService.planSelectListPy(hm);
//			MemberDTO member = gson.fromJson(jsonString, MemberDTO.class);
//			out.print(gson.toJson(member));
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		JsonObject jsonObject = new JsonObject();
		
		String str_list = gson.toJson(list);
		System.out.println("str_list > " + str_list);
		String str_selectCriteria = gson.toJson(selectCriteria);
		//System.out.println("str_selectCriteria > " + str_selectCriteria);
		jsonObject.addProperty("list", str_list);
		jsonObject.addProperty("selectCriteria", str_selectCriteria);
		
		String data = gson.toJson(jsonObject);
		//System.out.println("test > "+data);
		
		return data;
	}

	// 수업계획서 ajax 리스트 조회
	@GetMapping(value="/plan/selectlist", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String planSelectList(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String startDate = (String) request.getParameter("startDate");
		String endDate = (String) request.getParameter("endDate");
		String selectVal = (String) request.getParameter("selectVal");
		String searchVal = (String) request.getParameter("searchVal");
		String loginMemberIdx = (String) request.getParameter("loginMemberIdx");
		
		String currentPage = request.getParameter("currentPage");
        int pageNo = 1;

        if(currentPage != null && !"".equals(currentPage)) {
            pageNo = Integer.parseInt(currentPage);
        }
		
		Map<String, Object> hm = new HashMap<>();
		
		hm.put("startDate", startDate);
		hm.put("endDate", endDate);
		hm.put("selectVal", selectVal);
		hm.put("searchVal", searchVal);
		
		hm.put("loginMemberIdx", loginMemberIdx);
		
		int totalCount = lessonsService.planSelectTotalCount(hm);
		
		log.info("totalBoardCount : " + totalCount);
		
		/* 한 페이지에 보여 줄 게시물 수 */
        int limit = 10;		//얘도 파라미터로 전달받아도 된다.

        /* 한 번에 보여질 페이징 버튼의 갯수 */
        int buttonAmount = 5;

        /* 페이징 처리를 위한 로직 호출 후 페이징 처리에 관한 정보를 담고 있는 인스턴스를 반환받는다. */
        SelectCriteria selectCriteria = null;
        
        selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount);
        
        hm.put("startRow", selectCriteria.getStartRow());
        hm.put("endRow", selectCriteria.getEndRow());
        hm.put("limit", limit);
        
        System.out.println("hm : "+hm);
        
		List<LessonsPlanDTO> list = lessonsService.planSelectList(hm);
//		MemberDTO member = gson.fromJson(jsonString, MemberDTO.class);
//		out.print(gson.toJson(member));
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		JsonObject jsonObject = new JsonObject();
		
		String str_list = gson.toJson(list);
		System.out.println("str_list > " + str_list);
		String str_selectCriteria = gson.toJson(selectCriteria);
		//System.out.println("str_selectCriteria > " + str_selectCriteria);
		jsonObject.addProperty("list", str_list);
		jsonObject.addProperty("selectCriteria", str_selectCriteria);
		
		String data = gson.toJson(jsonObject);
		//System.out.println("test > "+data);
		
		return data;
	}
	
	// 수업계획서 ajax 리스트 조회
		@GetMapping(value="/report/selectlist", produces = "application/json; charset=UTF-8")
		@ResponseBody
		public String reportSelectList(HttpServletRequest request, HttpServletResponse response) throws IOException {
			
			String startDate = (String) request.getParameter("startDate");
			String endDate = (String) request.getParameter("endDate");
			String selectVal = (String) request.getParameter("selectVal");
			String searchVal = (String) request.getParameter("searchVal");
			
			String currentPage = request.getParameter("currentPage");
	        int pageNo = 1;

	        if(currentPage != null && !"".equals(currentPage)) {
	            pageNo = Integer.parseInt(currentPage);
	        }
			
			Map<String, Object> hm = new HashMap<>();
			
			hm.put("startDate", startDate);
			hm.put("endDate", endDate);
			hm.put("selectVal", selectVal);
			hm.put("searchVal", searchVal);
			
			int totalCount = lessonsService.reportSelectTotalCount(hm);
			
			log.info("totalBoardCount : " + totalCount);
			
			/* 한 페이지에 보여 줄 게시물 수 */
	        int limit = 10;		//얘도 파라미터로 전달받아도 된다.

	        /* 한 번에 보여질 페이징 버튼의 갯수 */
	        int buttonAmount = 5;

	        /* 페이징 처리를 위한 로직 호출 후 페이징 처리에 관한 정보를 담고 있는 인스턴스를 반환받는다. */
	        SelectCriteria selectCriteria = null;
	        
	        selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount);
	        
	        hm.put("startRow", selectCriteria.getStartRow());
	        hm.put("endRow", selectCriteria.getEndRow());
	        hm.put("limit", limit);
	        
	        System.out.println("hm : "+hm);
	        
			List<LessonsReportDTO> list = lessonsService.reportSelectList(hm);
//			MemberDTO member = gson.fromJson(jsonString, MemberDTO.class);
//			out.print(gson.toJson(member));
			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
			JsonObject jsonObject = new JsonObject();
			
			String str_list = gson.toJson(list);
			System.out.println("str_list > " + str_list);
			String str_selectCriteria = gson.toJson(selectCriteria);
			//System.out.println("str_selectCriteria > " + str_selectCriteria);
			jsonObject.addProperty("list", str_list);
			jsonObject.addProperty("selectCriteria", str_selectCriteria);
			
			String data = gson.toJson(jsonObject);
			//System.out.println("test > "+data);
			
			return data;
		}
	
	// 수업계획서 등록
	@PostMapping("/plan/register")
	public String planReg(HttpServletRequest request, @ModelAttribute LessonsPlanDTO lessonsPlanDTO, RedirectAttributes rttr) {
		
		System.out.println("go>"+lessonsPlanDTO);
		
		int regMem = Integer.parseInt(request.getParameter("loginMemberIdx"));
		lessonsPlanDTO.setRegMem(regMem);
		int result = lessonsService.planReg(lessonsPlanDTO);
		
		String message = "";
		
		if(result > 0) {
			message = "저장에 성공하였습니다.";
		} else {
			message = "저장에 실패하였습니다.";
		} 
	
		rttr.addFlashAttribute("message", message);
		return "redirect:/lessons/plan";
	}
	
	// 수업계획서 카테고리 ajax
	@PostMapping(value="/plan/register/category", produces = "application/json; charset=UTF-8")
	@ResponseBody
    public String PlanRegCategory() {
		
		List<LesEmployeeDTO> empList = lessonsService.PlanRegCategoryEmp();
		List<ClassKindDTO> ckList = lessonsService.PlanRegCategoryCk();
		
		System.out.println("empList > " + empList);
		System.out.println("ckList > " + ckList);
		
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		JsonObject jsonObject = new JsonObject();
		
		String str_empList = gson.toJson(empList);
		String str_ckList = gson.toJson(ckList);
		
		jsonObject.addProperty("empList", str_empList);
		jsonObject.addProperty("ckList", str_ckList);
		
		String data = gson.toJson(jsonObject);
		log.info(data);
		
		return data;
    }
	
	// 수업계획서 수정
	@PostMapping("/plan/modify")
	public String planModify(@ModelAttribute LessonsPlanDTO lessonsPlanDTO, RedirectAttributes rttr) {
		
		System.out.println("go>"+lessonsPlanDTO);
		
		int result = lessonsService.planMod(lessonsPlanDTO);
		
		String message = "";
		
		if(result > 0) {
			message = "수정에 성공하였습니다.";
		} else {
			message = "수정에 실패하였습니다.";
		} 
	
		rttr.addFlashAttribute("message", message);
		return "redirect:/lessons/plan";
	}
	
	@PostMapping("/report/modify")
	public String reportModify(@ModelAttribute LessonsReportDTO lessonsReportDTO, RedirectAttributes rttr) {
		
		int result = lessonsService.reportMod(lessonsReportDTO);
		
		System.out.println("lessonsReportDTO > " + lessonsReportDTO);
		
		String message = "";
		
		if(result > 0) {
			message = "저장에 성공하였습니다.";
		} else {
			message = "저장에 실패하였습니다.";
		} 
	
		rttr.addFlashAttribute("message", message);
		return "redirect:/lessons/report";
	}
	
	
	
	@PostMapping(value="/timetable/calendar/select", produces = "application/json; charset=UTF-8")
	@ResponseBody
    public String timeTablecalendarSelect() {
		
		List<LessonsPlanDTO> list = lessonsService.timeTablecalendarSelect();
		
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		String data = gson.toJson(list);
		log.info("달력 : "+data);
		
		return data;
	}
	
	@PostMapping("/timetable/modify")
	public String timeTableModify(HttpServletRequest request, RedirectAttributes rttr) {
		
		String timeIdx= request.getParameter("timeIdx");
		String[] period = request.getParameterValues("period");
		String[] emp = request.getParameterValues("emp");
		String[] contents = request.getParameterValues("contents");
		
		System.out.println("timeIdx > " + timeIdx);
		
		int result1 = lessonsService.timeTableDelete(timeIdx);
		
		log.info("시간표 삭제 result1 > " + result1);
		
		Map<String, String> hm = null;
		
		int cnt = 0;
		int result = 0;
		
		for(int i = 0; i < period.length; i++) {
			
			hm = new HashMap<>();
			
			hm.put("timeIdx", timeIdx);
			hm.put("period", period[i]);
			hm.put("emp", emp[i]);
			hm.put("contents", contents[i]);
			
			int result2 = lessonsService.timeTableModify(hm);
			
			if(result2 > 0) {
				cnt++;
				if(cnt == period.length) {
					log.info("시간표 등록 > " + cnt + " / " + period.length);
					result = 1;
				}
			}
				
			hm.clear();
		}
		
		String message = "";
		
		if(result > 0) {
			message = "수정에 성공하였습니다.";
		} else {
			message = "수정에 실패하였습니다.";
		} 
	
		rttr.addFlashAttribute("message", message);
		return "redirect:/lessons/timetablecalendar";
	}
	
	
	
	
}
