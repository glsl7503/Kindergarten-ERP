package com.kindergarten.hi.student.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kindergarten.hi.common.paging.Pagenation;
import com.kindergarten.hi.common.paging.SelectCriteria;
import com.kindergarten.hi.student.model.dto.AttendanceDTO;
import com.kindergarten.hi.student.model.dto.ParentsDTO;
import com.kindergarten.hi.student.model.dto.StudentDTO;
import com.kindergarten.hi.student.model.service.StudentService;


@Controller
@RequestMapping("/student")
public class StudentController {
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private final StudentService studentService;
    
    public StudentController(StudentService studentService) {
    	
    	this.studentService = studentService;
    }
	
	@GetMapping("/studentselectlist") /* 전체 조회 */
	public ModelAndView goStudentList(HttpServletRequest request, ModelAndView mv) {
		log.info("");
        log.info("");
        log.info("[StudentController] =========================================================");
        
        String currentPage = request.getParameter("currentPage");
        int pageNo = 1;

        if(currentPage != null && !"".equals(currentPage)) {
            pageNo = Integer.parseInt(currentPage);
        }

        String searchCondition = request.getParameter("searchCondition");
        String searchValue = request.getParameter("searchValue");

        Map<String, String> searchMap = new HashMap<>();
        searchMap.put("searchCondition", searchCondition);
        searchMap.put("searchValue", searchValue);

        log.info("[BoardController] 컨트롤러에서 검색조건 확인하기 : " + searchMap);

        /*
         * 전체 게시물 수가 필요하다.
         * 데이터베이스에서 먼저 전체 게시물 수를 조회해올 것이다.
         * 검색조건이 있는 경우 검색 조건에 맞는 전체 게시물 수를 조회한다.
         */
        int totalCount = studentService.selectTotalCount(searchMap);
        log.info("[BoardController] totalBoardCount : " + totalCount);

        /* 한 페이지에 보여 줄 게시물 수 */
        int limit = 10;		//얘도 파라미터로 전달받아도 된다.

        /* 한 번에 보여질 페이징 버튼의 갯수 */
        int buttonAmount = 5;

        /* 페이징 처리를 위한 로직 호출 후 페이징 처리에 관한 정보를 담고 있는 인스턴스를 반환받는다. */
        SelectCriteria selectCriteria = null;

        if(searchCondition != null && !"".equals(searchCondition)) {
            selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, searchCondition, searchValue);
        } else {
            selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount);
        }

        log.info("[BoardController] selectCriteria : " + searchCondition);

        List<StudentDTO> goStudentList = studentService.selectAllStudentListt(selectCriteria);
        log.info("[StudentController] goStudentList : " + goStudentList);

        mv.addObject("goStudentList", goStudentList);
        mv.addObject("selectCriteria", selectCriteria);
        mv.setViewName("student/studentSelectList");

        log.info("[StudentController] =========================================================");

        return mv;
    }	
		
		
	@GetMapping("/studentselect")  /* 상세 조회 */
	public ModelAndView goStudentselect(@ModelAttribute StudentDTO student, ModelAndView mv, HttpServletRequest request, Model model) {		
		        log.info("");
		        log.info("");
		        log.info("[BoardController] =========================================================");

		        /* 원생 개인정보 조회*/
		        Long no = Long.valueOf(request.getParameter("no"));
		        System.out.println("nonono : " + no);
		        StudentDTO student1 = studentService.selectStudentDetail(no);
		        List<StudentDTO> choice =  studentService.selectChStudentDetail(no);	        
		        
		        /* 원생 출석 일수 조회*/
		        List<StudentDTO> attendance=  studentService.selectAdStudentDetail(no);
		       for(StudentDTO tt : attendance) {
		    	   System.out.println("치킨 : " + tt);
		       }
		      
		        System.out.println();
		        mv.addObject("attendance", attendance);	
		        mv.addObject("choice", choice);	
		        mv.addObject("student", student1);		
		
		        mv.setViewName("student/Studentselect");
		        
		return mv;
	}
	
	
	@GetMapping("/studentinsert")/* 등록 */
	public String goStudentInsert() {
		
		return "student/studentinsert";
		
	}
	@PostMapping("/studentinsert") /* 등록 */
	public String goStudentInsert2(@ModelAttribute StudentDTO student, @ModelAttribute ParentsDTO parents, RedirectAttributes rttr,HttpServletRequest request) {
		

		System.out.println("student :" + student);
		// 해쉬맵으로 다 받으시오 dto x
		student.setResident(student.getResident() + "-" + request.getParameter("resident2"));
		
		/* 보육일수 */
		int p1_1 = Integer.parseInt(request.getParameter("p1_1"));
		int p1_2 = Integer.parseInt(request.getParameter("p1_2"));
		int p2_1 = Integer.parseInt(request.getParameter("p2_1"));
		int p2_2 = Integer.parseInt(request.getParameter("p2_2"));
		int p3_1 = Integer.parseInt(request.getParameter("p3_1"));
		int p3_2 = Integer.parseInt(request.getParameter("p3_2"));
		/* 결석 */
		int p1_3 = Integer.parseInt(request.getParameter("p1_3"));
		int p1_4 = Integer.parseInt(request.getParameter("p1_4"));
		int p2_3 = Integer.parseInt(request.getParameter("p2_3"));
		int p2_4 = Integer.parseInt(request.getParameter("p2_4"));
		int p3_3 = Integer.parseInt(request.getParameter("p3_3"));
		int p3_4 = Integer.parseInt(request.getParameter("p3_4"));
		/* 지각 */
		int p1_5 = Integer.parseInt(request.getParameter("p1_5"));
		int p1_6 = Integer.parseInt(request.getParameter("p1_6"));
		int p2_5 = Integer.parseInt(request.getParameter("p2_5"));
		int p2_6 = Integer.parseInt(request.getParameter("p2_6"));
		int p3_5 = Integer.parseInt(request.getParameter("p3_5"));
		int p3_6 = Integer.parseInt(request.getParameter("p3_6"));
		/* 병결 */
		int p1_7 = Integer.parseInt(request.getParameter("p1_7"));
		int p1_8 = Integer.parseInt(request.getParameter("p1_8"));
		int p2_7 = Integer.parseInt(request.getParameter("p2_7"));
		int p2_8 = Integer.parseInt(request.getParameter("p2_8"));
		int p3_7 = Integer.parseInt(request.getParameter("p3_7"));
		int p3_8 = Integer.parseInt(request.getParameter("p3_8"));
		/* 보호자 */
		String name1 = request.getParameter("name1");
		String name2 = request.getParameter("name2");
		String phone1 = request.getParameter("phone1");
		String phone2 = request.getParameter("phone2");
		String choice1 = request.getParameter("parents1");
		String choice2 = request.getParameter("parents2");
		
		Map<String, Object> hm = new HashMap<>();
		
		int total = p1_1 + p1_2 + p2_1 + p2_2 + p3_1 + p3_2;

		AttendanceDTO attendence1 = new AttendanceDTO();
		int att1 = p1_1 - (p1_3 + p1_5 + p1_7);
		attendence1.setTotal(total);
		attendence1.setAtt(att1);
		attendence1.setNon(p1_3);
		attendence1.setLate(p1_5);
		attendence1.setSick(p1_7);
		
		AttendanceDTO attendence2 = new AttendanceDTO();
		int att2 = p1_2 - (p1_4 + p1_6 + p1_8);
		attendence2.setTotal(total);
		attendence2.setAtt(att2);
		attendence2.setNon(p1_4);
		attendence2.setLate(p1_6);
		attendence2.setSick(p1_8);
		
		AttendanceDTO attendence3 = new AttendanceDTO();
		int att3 = p2_1 - (p2_3 + p2_5 + p2_7);
		attendence3.setTotal(total);
		attendence3.setAtt(att3);
		attendence3.setNon(p2_3);
		attendence3.setLate(p2_5);
		attendence3.setSick(p2_7);
		
		AttendanceDTO attendence4 = new AttendanceDTO();
		int att4 = p2_2 - (p2_4 + p2_6 + p2_8);
		attendence4.setTotal(total);
		attendence4.setAtt(att4);
		attendence4.setNon(p2_4);
		attendence4.setLate(p2_6);
		attendence4.setSick(p2_8);
		
		AttendanceDTO attendence5 = new AttendanceDTO();
		int att5 = p3_1 - (p3_3 + p3_5 + p3_7);
		attendence5.setTotal(total);
		attendence5.setAtt(att4);
		attendence5.setNon(p3_3);
		attendence5.setLate(p3_5);
		attendence5.setSick(p3_7);
		
		AttendanceDTO attendence6 = new AttendanceDTO();
		int att6 = p3_2 - (p3_4 + p3_6 + p3_8);
		attendence6.setTotal(total);
		attendence6.setAtt(att4);
		attendence6.setNon(p3_4);
		attendence6.setLate(p3_6);
		attendence6.setSick(p3_8);
		
		hm.put("attendence1", attendence1);
		hm.put("attendence2", attendence2);
		hm.put("attendence3", attendence3);
		hm.put("attendence4", attendence4);
		hm.put("attendence5", attendence5);
		hm.put("attendence6", attendence6);
		
		ParentsDTO parent1 = new ParentsDTO();
		
		parent1.setName(name1);
		parent1.setPhone(phone1);
		parent1.setChoice(choice1);
		
		ParentsDTO parent2 = new ParentsDTO();
		
		parent2.setName(name2);
		parent2.setPhone(phone2);
		parent2.setChoice(choice2);
		
		hm.put("parent1", parent1);
		hm.put("parent2", parent2);
		
		System.out.println(hm.get("name1"));
		System.out.println(hm.get("name2"));		
		System.out.println(hm.get("phone1"));
		System.out.println(hm.get("phone2"));
		System.out.println(hm.get("parents1"));
		System.out.println(hm.get("parents2"));
		
		System.out.println("hm 조회: " + hm);

		studentService.registstudent(student, parents, hm);
		// 졸업일 지정 안 할시 400에러 
		
	    rttr.addFlashAttribute("message", "게시글 등록에 성공하셨습니다!");
		return "redirect:/student/studentselectlist";
	}
	
	@GetMapping("/studentupdate")
	public ModelAndView gostudentUpdate( HttpServletRequest request, ModelAndView mv) {
		
        Long no = Long.valueOf(request.getParameter("no"));
        System.out.println("nonono : " + no);
        StudentDTO student1 = studentService.selectStudentDetail(no);
        List<StudentDTO> choice =  studentService.selectChStudentDetail(no);	        
        
        /* 원생 출석 일수 조회*/
        List<StudentDTO> attendance=  studentService.selectAdStudentDetail(no);
       for(StudentDTO tt : attendance) {
    	   System.out.println("치킨 : " + tt);
       }
      
        System.out.println();
        mv.addObject("attendance", attendance);	
        mv.addObject("choice", choice);	
        mv.addObject("student", student1);		

        mv.setViewName("student/studentupdate");
        
       return mv;		
			
	}
	
	@PostMapping("/studentupdate2") /* 수정 */
	public String goStudentUpdate2(@ModelAttribute StudentDTO student, RedirectAttributes rttr, HttpServletRequest request) {
		

        log.info("");
        log.info("");
        log.info("[NoticeController] modifyNotice =========================================================");

        log.info("[NoticeController] studentupdate : "+ student);
        System.out.println("student :" + student);
		// 해쉬맵으로 다 받으시오 dto x
		student.setResident(student.getResident() + "-" + request.getParameter("resident2"));
		
		/* 보육일수 */
		int p1_1 = Integer.parseInt(request.getParameter("p1_1"));
		int p1_2 = Integer.parseInt(request.getParameter("p1_2"));
		int p2_1 = Integer.parseInt(request.getParameter("p2_1"));
		int p2_2 = Integer.parseInt(request.getParameter("p2_2"));
		int p3_1 = Integer.parseInt(request.getParameter("p3_1"));
		int p3_2 = Integer.parseInt(request.getParameter("p3_2"));
		/* 결석 */
		int p1_3 = Integer.parseInt(request.getParameter("p1_3"));
		int p1_4 = Integer.parseInt(request.getParameter("p1_4"));
		int p2_3 = Integer.parseInt(request.getParameter("p2_3"));
		int p2_4 = Integer.parseInt(request.getParameter("p2_4"));
		int p3_3 = Integer.parseInt(request.getParameter("p3_3"));
		int p3_4 = Integer.parseInt(request.getParameter("p3_4"));
		/* 지각 */
		int p1_5 = Integer.parseInt(request.getParameter("p1_5"));
		int p1_6 = Integer.parseInt(request.getParameter("p1_6"));
		int p2_5 = Integer.parseInt(request.getParameter("p2_5"));
		int p2_6 = Integer.parseInt(request.getParameter("p2_6"));
		int p3_5 = Integer.parseInt(request.getParameter("p3_5"));
		int p3_6 = Integer.parseInt(request.getParameter("p3_6"));
		/* 병결 */
		int p1_7 = Integer.parseInt(request.getParameter("p1_7"));
		int p1_8 = Integer.parseInt(request.getParameter("p1_8"));
		int p2_7 = Integer.parseInt(request.getParameter("p2_7"));
		int p2_8 = Integer.parseInt(request.getParameter("p2_8"));
		int p3_7 = Integer.parseInt(request.getParameter("p3_7"));
		int p3_8 = Integer.parseInt(request.getParameter("p3_8"));
		/* 보호자 */
		String name1 = request.getParameter("name1");
		String name2 = request.getParameter("name2");
		String phone1 = request.getParameter("phone1");
		String phone2 = request.getParameter("phone2");
		String choice1 = request.getParameter("parents1");
		String choice2 = request.getParameter("parents2");
		int no1 = Integer.valueOf(request.getParameter("pNo1"));
		int no2 = Integer.valueOf(request.getParameter("pNo2"));
		
		
		Map<String, Object> hm = new HashMap<>();
		
		int total = p1_1 + p1_2 + p2_1 + p2_2 + p3_1 + p3_2;

		AttendanceDTO attendence1 = new AttendanceDTO();
		int att1 = p1_1 - (p1_3 + p1_5 + p1_7);
		attendence1.setTotal(total);
		attendence1.setAtt(att1);
		attendence1.setNon(p1_3);
		attendence1.setLate(p1_5);
		attendence1.setSick(p1_7);
		
		AttendanceDTO attendence2 = new AttendanceDTO();
		int att2 = p1_2 - (p1_4 + p1_6 + p1_8);
		attendence2.setTotal(total);
		attendence2.setAtt(att2);
		attendence2.setNon(p1_4);
		attendence2.setLate(p1_6);
		attendence2.setSick(p1_8);
		
		AttendanceDTO attendence3 = new AttendanceDTO();
		int att3 = p2_1 - (p2_3 + p2_5 + p2_7);
		attendence3.setTotal(total);
		attendence3.setAtt(att3);
		attendence3.setNon(p2_3);
		attendence3.setLate(p2_5);
		attendence3.setSick(p2_7);
		
		AttendanceDTO attendence4 = new AttendanceDTO();
		int att4 = p2_2 - (p2_4 + p2_6 + p2_8);
		attendence4.setTotal(total);
		attendence4.setAtt(att4);
		attendence4.setNon(p2_4);
		attendence4.setLate(p2_6);
		attendence4.setSick(p2_8);
		
		AttendanceDTO attendence5 = new AttendanceDTO();
		int att5 = p3_1 - (p3_3 + p3_5 + p3_7);
		attendence5.setTotal(total);
		attendence5.setAtt(att4);
		attendence5.setNon(p3_3);
		attendence5.setLate(p3_5);
		attendence5.setSick(p3_7);
		
		AttendanceDTO attendence6 = new AttendanceDTO();
		int att6 = p3_2 - (p3_4 + p3_6 + p3_8);
		attendence6.setTotal(total);
		attendence6.setAtt(att4);
		attendence6.setNon(p3_4);
		attendence6.setLate(p3_6);
		attendence6.setSick(p3_8);
		
		hm.put("attendence1", attendence1);
		hm.put("attendence2", attendence2);
		hm.put("attendence3", attendence3);
		hm.put("attendence4", attendence4);
		hm.put("attendence5", attendence5);
		hm.put("attendence6", attendence6);
		
		ParentsDTO parent1 = new ParentsDTO();
		
		parent1.setName(name1);
		parent1.setPhone(phone1);
		parent1.setChoice(choice1);
		parent1.setNo(no1);
		
		ParentsDTO parent2 = new ParentsDTO();
		
		parent2.setName(name2);
		parent2.setPhone(phone2);
		parent2.setChoice(choice2);
		parent2.setNo(no2);
		
		hm.put("parent1", parent1);
		hm.put("parent2", parent2);
		
		System.out.println(hm.get("name1"));
		System.out.println(hm.get("name2"));		
		System.out.println(hm.get("phone1"));
		System.out.println(hm.get("phone2"));
		System.out.println(hm.get("parents1"));
		System.out.println(hm.get("parents2"));
		
		System.out.println("hm 조회: " + hm);

        
		studentService.modifyStudent(student,hm);
		
		int no = student.getNo();
		
		rttr.addAttribute("no", no);
		
		return "redirect:/student/studentselect";
	}
	
	 @GetMapping("/delete")
	    public String removeNotice(HttpServletRequest request, RedirectAttributes rttr) {

	        Long no = Long.valueOf(request.getParameter("no"));

	        studentService.removeStudent(no);

	        rttr.addFlashAttribute("message", "공지사항 삭제에 성공하셨습니다!");

	        return "redirect:/student/studentselectlist";
	    }
	
	
}
