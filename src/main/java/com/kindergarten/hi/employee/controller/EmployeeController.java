 package com.kindergarten.hi.employee.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.kindergarten.hi.common.paging.Pagenation;
import com.kindergarten.hi.common.paging.SelectCriteria;
import com.kindergarten.hi.employee.model.dto.CalenderEmployeeDTO;
import com.kindergarten.hi.employee.model.dto.EmplAuthDTO;
import com.kindergarten.hi.employee.model.dto.EmployeeDTO;
import com.kindergarten.hi.employee.model.dto.HolidayDTO;
import com.kindergarten.hi.employee.model.dto.ManagementDTO;
import com.kindergarten.hi.employee.model.service.EmployeeService;
import com.kindergarten.hi.food.controller.DeleteException;
import com.kindergarten.hi.food.controller.InsertException;
import com.kindergarten.hi.food.controller.UpdateException;
import com.kindergarten.hi.login.model.dto.UserImpl;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	private final PasswordEncoder passwordEncoder;
	
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	private final EmployeeService employeeService;
	
	@Autowired
	public EmployeeController(EmployeeService employeeService, PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
		this.employeeService = employeeService;
	}
	
	/* 회원정보조회 */
	@GetMapping(value= "/list")
	public ModelAndView employeeList(HttpServletRequest request, ModelAndView mv) {
		
		 log.info("");
	     log.info("");
	     log.info("[EmployeeController] =========================================================");
		/*
         * 목록보기를 눌렀을 시 가장 처음에 보여지는 페이지는 1페이지이다.
         * 파라미터로 전달되는 페이지가 있는 경우 currentPage는 파라미터로 전달받은 페이지 수 이다.
         */
        String currentPage = request.getParameter("currentPage");
        int pageNo = 1;

        if(currentPage != null && !"".equals(currentPage)) {
            pageNo = Integer.parseInt(currentPage);
        }
        	if(pageNo <= 0) {
        	
        	pageNo = 1;
        }

        String searchCondition = request.getParameter("searchCondition");
        String searchValue = request.getParameter("searchValue");

        Map<String, String> searchMap = new HashMap<>();
        searchMap.put("searchCondition", searchCondition);
        searchMap.put("searchValue", searchValue);

        log.info("[EmployeeController] 컨트롤러에서 검색조건 확인하기 : " + searchMap);
        
        /*
         * 전체 게시물 수가 필요하다.
         * 데이터베이스에서 먼저 전체 게시물 수를 조회해올 것이다.
         * 검색조건이 있는 경우 검색 조건에 맞는 전체 게시물 수를 조회한다.
         */
        int totalCount = employeeService.selectTotalCount(searchMap);
        log.info("[EmployeeController] totalBoardCount : " + totalCount);

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

        log.info("[EmployeeController] selectCriteria : " + selectCriteria);

        /* 조회해 온다 */
        List<EmployeeDTO> employeeList = employeeService.selectEmployeeList(selectCriteria);

        log.info("[EmployeeController] employeeList : " + employeeList);

        mv.addObject("employeeList", employeeList);
        mv.addObject("selectCriteria", selectCriteria);
        log.info("[EmployeeController] SelectCriteria : " + selectCriteria);
        mv.setViewName("employee/employeeview");

        log.info("[EmployeeController] =========================================================");
        return mv;
    }

	/* 회원정보 삭제 */
	@GetMapping("/delete")
		public String employeeDelete(@ModelAttribute EmployeeDTO employee, RedirectAttributes rttr) throws employeeDeleteException {
		
		log.info("");
		log.info("");
		log.info("[employeeDelete] 들어옴 : =================================");

		System.out.println("employee : " + employee);
		
		employeeService.employeeDelete(employee);
		
		rttr.addFlashAttribute("message", "회원삭제에 성공하셨습니다 ! ");
		
		return  "redirect:/employee/list";
	}
	
	/* 회원정보 상세조회 */
	@GetMapping("/detail")
	public String selectEmployeeDetail(HttpServletRequest request, Model model) {
		 log.info("");
	     log.info("");
	     log.info("[selectEmployeeDetailController] =============================================================================");
	     
	     Long no = Long.valueOf(request.getParameter("no"));
	     
	     log.info("[selectEmployeeDetail] selectEmployeeDetail : " + no);

        EmployeeDTO employeeDetail = employeeService.selectEmployeeDetail(no);
        
        System.out.println("employeeDetail : " + employeeDetail);
        
        model.addAttribute("employee", employeeDetail);
        model.addAttribute("no",no);

        log.info("[SelectEmployeeDetail] selectEmployeeDetail=========================================================");

        return "employee/employeedetail";
	}
	
	/* 회원정보 수정 */
	@GetMapping("/update")
	public String employeeUpdate(@ModelAttribute EmployeeDTO employee, HttpServletRequest request, HttpServletResponse response,
            RedirectAttributes rttr) throws employeeUpdateException {
		log.info("");
		log.info("");
		log.info("[employeeUpdateController] 들어옴 : =================================");

		employeeService.employeeUpdate(employee);
				
		rttr.addFlashAttribute("message","회원정보가 수정 되었습니다 !");

		log.info("[employeeUpdateController] end : ==========================================");
		
		return "redirect:/employee/list";
	}
	
	/* 근태정보등록 */
	@PostMapping("/managementRegister")
	
	 public String managementRegister(@ModelAttribute ManagementDTO management, RedirectAttributes rttr) throws managementRegisterException {

        log.info("");
        log.info("");
        log.info("[ManagementController] registBoard =========================================================");
        log.info("[ManagementController] registBoard Request : " + management );

        employeeService.managementRegister(management);

        rttr.addFlashAttribute("message", "근태사유서가 등록 되었습니다 ! ");

        log.info("[ManagementController] registBoard =========================================================");

        return "redirect:/employee/managementList";
    }
	
	/* 근태정보등록 페이지 가기*/
	@GetMapping("/managementRegister")
	public String managementRegisterPage() {
		
		return "employee/managementregister";
	}
	
	/* 근태정보조회 */
	@GetMapping("/managementList")
	public ModelAndView managementList(HttpServletRequest request, ModelAndView mv) {
		
		 log.info("");
	     log.info("");
	     log.info("[ManagementController] =========================================================");
		/*
        * 목록보기를 눌렀을 시 가장 처음에 보여지는 페이지는 1페이지이다.
        * 파라미터로 전달되는 페이지가 있는 경우 currentPage는 파라미터로 전달받은 페이지 수 이다.
        */
       String currentPage = request.getParameter("currentPage");
       int pageNo = 1;

       if(currentPage != null && !"".equals(currentPage)) {
           pageNo = Integer.parseInt(currentPage);
       }
       
       if(pageNo <= 0) {
       	
       	pageNo = 1;
       }

       String searchCondition = request.getParameter("searchCondition");
       String searchValue = request.getParameter("searchValue");

       Map<String, String> searchMap = new HashMap<>();
       searchMap.put("searchCondition", searchCondition);
       searchMap.put("searchValue", searchValue);

       log.info("[ManagementController] 컨트롤러에서 검색조건 확인하기 : " + searchMap);
       
       /*
        * 전체 게시물 수가 필요하다.
        * 데이터베이스에서 먼저 전체 게시물 수를 조회해올 것이다.
        * 검색조건이 있는 경우 검색 조건에 맞는 전체 게시물 수를 조회한다.
        */
       int totalCount = employeeService.selectTotalCount2(searchMap);
       log.info("[ManagementController] totalBoardCount : " + totalCount);

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

       log.info("[ManagementController] selectCriteria : " + selectCriteria);

       /* 조회해 온다 */
       List<ManagementDTO> managementList = employeeService.selectManagementList(selectCriteria);

       log.info("[ManagementController] managementList : " + managementList);

       mv.addObject("managementList", managementList);
       mv.addObject("selectCriteria", selectCriteria);
       log.info("[ManagementController] SelectCriteria : " + selectCriteria);
       mv.setViewName("employee/managementview");

       log.info("[ManagementController] =========================================================");
       return mv;
   }
	
	/* 근태정보 상세조회 */	
	@GetMapping("/managementdetail")
	public String selectManagementDetail(HttpServletRequest request, Model model) {
		 log.info("");
	     log.info("");
	     log.info("[selectManagementDetailController] =============================================================================");
	     
	     Long no = Long.valueOf(request.getParameter("no"));
	     
	     log.info("[selectManagementDetail] selectManagementDetail : " + no);

        ManagementDTO managementDetail = employeeService.selectManagementDetail(no);
        
        System.out.println("managementDetail : " + managementDetail);
       
        model.addAttribute("management", managementDetail);
        model.addAttribute("no",no);

        log.info("[SelectManagementDetail] selectManagementDetail=========================================================");

        return "employee/managementupdate";
	}
	
	
	/* 근태정보제출하기 */
	@GetMapping("/managementsubmit")
	public String managementsubmit(@ModelAttribute ManagementDTO management, RedirectAttributes rttr) throws managementUpdateException{
		
	employeeService.managementsubmit(management);
	rttr.addFlashAttribute("message","근태사유서가 제출 되었습니다.");
	
		return "redirect:/employee/managementList";
	}
	/* 근태정보수정 */
	@GetMapping("/managementupdate")
	public String managementupdate(@ModelAttribute ManagementDTO management, RedirectAttributes rttr) throws managementUpdateException{
		
		log.info("");
		log.info("");
		log.info("[managementupdate 들어옴 : =================================");

		System.out.println("managementupdate : " + management);

		employeeService.managementUpdate(management);

		rttr.addFlashAttribute("message","근태정보가 수정 되었습니다.");
		
		log.info("[managementupdate] end : ==========================================");
		
		return "redirect:/employee/managementList";
	}
	
	/* 근태정보삭제 */
	@GetMapping("/managementdelete")
	public String managementDelete(HttpServletRequest request, RedirectAttributes rttr) throws managementDeleteException {
	
	int no = Integer.parseInt(request.getParameter("no"));
	
	System.out.println("no : " + no);
	
	employeeService.managementDelete(no);
	
	rttr.addFlashAttribute("message", "근태정보가 삭제되었습니다 ! ");
	
	return  "redirect:/employee/managementList";

	}

	
	@GetMapping("/employeecal")
	public String employeecal() {
		return "employee/employeecal";	
	}
	
	/* 캘린더 리스트 조회 */
	@ResponseBody
	@GetMapping(value="/callist", produces = "application/json; charset=utf-8")
	public String selectempCalenderList() {
		log.info("");
        log.info("");
        log.info("[CalendarController] 시작 : =====================================");
        
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        
        
        List<CalenderEmployeeDTO> empcalList = employeeService.selectempCalenderList();
        
        System.out.println("캘린더 정보들어오는지 확인 : " + empcalList);
        log.info("[CalendarController] : " + gson.toJson(empcalList));
        log.info("[CalendarController] 끝 : =========================================================");
        
        return gson.toJson(empcalList);
	}
	
	/* 출결관리 캘린더 */
	@GetMapping("employeecalender")
	public String insertCalender(@ModelAttribute CalenderEmployeeDTO calender, RedirectAttributes rttr, @AuthenticationPrincipal User user) throws employeeCalenderException {
		
		log.info("");
		log.info("");
		log.info("[insertCalender] 시작 : =================================================");
		
		System.out.println("calenderDTO" + calender);
		
		int no = ((UserImpl) user).getEmpNo(); //LoginEmployeeDTO 에 있는 getEmpNo 가져오기
		
		employeeService.insertemployeeCalender(calender, no);
		
		return "redirect:/employee/employeecal";
	}
	 /* 출결관리 캘린더2 */ 
	@GetMapping("employeecalender2")
	public String insert2Calender(@ModelAttribute CalenderEmployeeDTO calender, RedirectAttributes rttr, @AuthenticationPrincipal User user) throws employeeCalenderException {
		
		log.info("");
		log.info("");
		log.info("[insertCalender] 시작 : =================================================");
		
		System.out.println("calenderDTO" + calender);
		
		int no = ((UserImpl) user).getEmpNo(); //LoginEmployeeDTO 에 있는 getEmpNo 가져오기
		
		employeeService.insertemployee2Calender(calender,no);
		
		return "redirect:/employee/employeecal";
	}
	
	@PostMapping("/employeeregister")
	public String registerEmployee(@ModelAttribute EmployeeDTO employeeDTO,@ModelAttribute EmplAuthDTO emplAuthDTO, HttpServletRequest request, RedirectAttributes rttr) {
		
		String address = request.getParameter("zipcode") + "$" + employeeDTO.getAddre() + "$" + request.getParameter("addre2") + "$" + request.getParameter("addre3");
		System.out.println(address);
		int value = Integer.parseInt(request.getParameter("value"));
		String phone = employeeDTO.getPhone() + request.getParameter("phone2") + request.getParameter("phone3");
//		employeeDTO.setPhone(employeeDTO.getPhone().replace("-", ""));
		emplAuthDTO.setAuthNum(value);
		employeeDTO.setAddre(address);
		employeeDTO.setPhone(phone);
		System.out.println(employeeDTO);
		System.out.println(emplAuthDTO);
		System.out.println(employeeDTO.getPwd());
		System.out.println(employeeDTO.getId());
		System.out.println(value);
		employeeDTO.setPwd(passwordEncoder.encode(employeeDTO.getPwd()));
		employeeDTO.setEmail(employeeDTO.getEmail()+"@"+request.getParameter("email2"));
		int result = employeeService.insertEmployee(employeeDTO, emplAuthDTO);
		rttr.addFlashAttribute("message", "회원 가입에 성공하였습니다.");
		
		return "redirect:/";
	}
	
	@PostMapping("/idDupCheck")
    public ResponseEntity<String> checkDuplication(@RequestBody EmployeeDTO employeeDTO) throws JsonProcessingException {

        log.info("");
        log.info("");
        log.info("[EmployeeController] checkDuplication ==========================================================");

        String result = "사용 가능한 아이디 입니다.";
        log.info("[EmployeeController] Request Check ID : " + employeeDTO.getId());

        if("".equals(employeeDTO.getId())) {
            log.info("[EmployeeController] No Input Employee ID");
            result = "아이디를 입력해 주세요";
        } else if(employeeService.selectEmployeeById(employeeDTO.getId())) {
            log.info("[EmployeeController] Already Exist");
            result = "중복된 아이디가 존재합니다.";
        }

        log.info("[MemberController] checkDuplication ==========================================================");

        return ResponseEntity.ok(result);
    }
	
	
	// 권한체크
	@GetMapping("/vacationPy")
	public String checkSup(@AuthenticationPrincipal UserImpl user, HttpServletRequest request,RedirectAttributes rttr) {
		
		 int status = user.getLoginEmployeeRoleList().get(0).getAuthorityCode(); //권한조회
		 String message = "";
		
	        if(status !=3) {
	        	message = "권한이 없습니다.";
	        	rttr.addFlashAttribute("message", message);
	       return "redirect:/";
	        }
	        
	        return "redirect:/employee/vacationSup";
	}
	

	/* 결제- 휴가관리 조회 페이지 메소드 (페이징) */
	@GetMapping("/vacationSup")
	public ModelAndView selectvacationSup(ModelAndView mv, HttpServletRequest request) {
		
		log.info("");
		log.info("[ insertVacation 컨트롤러 시작 ] ============================");
		
		

		
        String currentPage = request.getParameter("currentPage");
        int pageNo = 1;

        if(currentPage != null && !"".equals(currentPage)) {
            pageNo = Integer.parseInt(currentPage);
        }
        
        if(pageNo == 0) {
        	
        	pageNo= 1;
        }
        
        String searchCondition = request.getParameter("searchCondition");
        String searchValue = request.getParameter("searchValue");

        Map<String, Object> searchMap = new HashMap<>();
        searchMap.put("searchCondition", searchCondition);
        searchMap.put("searchValue", searchValue);
       
        int totalCount = employeeService.selectVacationTotalCountPy(searchMap);

        /* 한 페이지에 보여 줄 게시물 수 */
        int limit = 10;		//얘도 파라미터로 전달받아도 된다.

        /* 한 번에 보여질 페이징 버튼의 갯수 */
        int buttonAmount = 5;

        /* 페이징 처리를 위한 로직 호출 후 페이징 처리에 관한 정보를 담고 있는 인스턴스를 반환받는다. */
        com.kindergarten.hi.common.paging.SelectCriteria selectCriteria = null;

        
        if(searchCondition != null && !"".equals(searchCondition)) {
            selectCriteria = com.kindergarten.hi.common.paging.Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, searchCondition, searchValue);
        } else {
            selectCriteria = com.kindergarten.hi.common.paging.Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount);
        }

        Map<String, Object> foodMap = new HashMap<>();
        foodMap.put("selectCriteria",selectCriteria);

        
        
		List<HolidayDTO> empList = employeeService.selectVacationListPy(foodMap);
		
		log.info("empList : " + empList);
		
		mv.addObject("selectCriteria", selectCriteria);
		mv.addObject("empList", empList);
		mv.setViewName("/payment/vacation");
		
		return mv;
	}
	
	
	/* 휴가관리 조회 페이지 메소드 (페이징) */
	@GetMapping("/vacation")
	public ModelAndView selectVacation(@AuthenticationPrincipal UserImpl user, ModelAndView mv, HttpServletRequest request) {
		
		log.info("");
		log.info("[ insertVacation 컨트롤러 시작 ] ============================");
		
		System.out.println("user" + user);
		int userId = user.getEmpNo();
		
		System.out.println("---=====================" + userId);
		
        String currentPage = request.getParameter("currentPage");
        int pageNo = 1;

        if(currentPage != null && !"".equals(currentPage)) {
            pageNo = Integer.parseInt(currentPage);
        }
        
        if(pageNo == 0) {
        	
        	pageNo= 1;
        }
        
        String searchCondition = request.getParameter("searchCondition");
        String searchValue = request.getParameter("searchValue");

        Map<String, Object> searchMap = new HashMap<>();
        searchMap.put("searchCondition", searchCondition);
        searchMap.put("searchValue", searchValue);
        searchMap.put("id", userId);
       
        int totalCount = employeeService.selectVacationTotalCount(searchMap);

        /* 한 페이지에 보여 줄 게시물 수 */
        int limit = 10;		//얘도 파라미터로 전달받아도 된다.

        /* 한 번에 보여질 페이징 버튼의 갯수 */
        int buttonAmount = 5;

        /* 페이징 처리를 위한 로직 호출 후 페이징 처리에 관한 정보를 담고 있는 인스턴스를 반환받는다. */
        com.kindergarten.hi.common.paging.SelectCriteria selectCriteria = null;

        
        if(searchCondition != null && !"".equals(searchCondition)) {
            selectCriteria = com.kindergarten.hi.common.paging.Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, searchCondition, searchValue);
        } else {
            selectCriteria = com.kindergarten.hi.common.paging.Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount);
        }

        Map<String, Object> foodMap = new HashMap<>();
        foodMap.put("selectCriteria",selectCriteria);
        foodMap.put("userId",userId); 
        
        
        
		List<HolidayDTO> empList = employeeService.selectVacationList(foodMap);
		
		log.info("empList : " + empList);
		
		mv.addObject("selectCriteria", selectCriteria);
		mv.addObject("empList", empList);
		mv.setViewName("/employee/vacation");
		
		return mv;
	}
	
	/* 휴가관리 등록페이지 메소드 */
	@GetMapping("/vacation/insert")
	public ModelAndView vacationInsertPage(ModelAndView mv) {
		
		mv.setViewName("/employee/vacation_insert");
		
		return mv;
	}
	
	/* 회원관리 등록하기 메소드  */
	@PostMapping("/vacation/insert")
	public String insertVacation(@AuthenticationPrincipal UserImpl user,@ModelAttribute HolidayDTO holi, RedirectAttributes rttr) throws InsertException{
	
		log.info("");
		log.info("[ insertVacation 컨트롤러 시작 ] ============================");

		int userNo = user.getEmpNo();
		
		employeeService.insertVacation(holi);
		
		System.out.println("holi : " + holi);
		
		employeeService.insertVacationEmp(userNo);

		rttr.addFlashAttribute("message", "등록되었습니다.");
		
		return "redirect:/employee/vacation";
	}
	
	/* 휴가관리 상세조회 메소드 */
	@GetMapping("/vacation/detailPy")
	public String selectVacationDetailPy(HttpServletRequest request, Model model) {
		
		log.info("");
	     log.info("");
	     log.info("[디테일 컨트롤러 확인] =============================================================================");

	     Long no = Long.valueOf(request.getParameter("no"));
	     
        HolidayDTO holiDetail = employeeService.selectVacationDetail(no);
        
        System.out.println("holiDetail : " + holiDetail);
        
        model.addAttribute("holiDetail", holiDetail);
        model.addAttribute("no",no);

        log.info("[휴가관리 끝]  =========================================================");

        return "payment/vacation_detail";
	}
	
	
	
	/* 휴가관리 상세조회 메소드 */
	@GetMapping("/vacation/detail")
	public String selectVacationDetail(HttpServletRequest request, Model model) {
		
		log.info("");
	     log.info("");
	     log.info("[디테일 컨트롤러 확인] =============================================================================");

	     Long no = Long.valueOf(request.getParameter("no"));
	     
        HolidayDTO holiDetail = employeeService.selectVacationDetail(no);
        
        System.out.println("holiDetail : " + holiDetail);
        
        model.addAttribute("holiDetail", holiDetail);
        model.addAttribute("no",no);

        log.info("[휴가관리 끝]  =========================================================");

        return "employee/vacation_detail";
	}
	
	/* 휴가관리 수정하기 메소드 */
	@PostMapping("/vacation/update")
	public String updateVacation(@ModelAttribute HolidayDTO holi, RedirectAttributes rttr) throws UpdateException{
		
		employeeService.updateVacation(holi);

		rttr.addFlashAttribute("message","수정 되었습니다.");
		
		
		return "redirect:/employee/vacation";
	}
	
	/* 휴가관리 삭제하기 메소드 */
	@PostMapping("/vacation/delete")
	public String deteleVacation(@ModelAttribute HolidayDTO holi, RedirectAttributes rttr) throws DeleteException{
		
		employeeService.deteleVacation(holi);

		rttr.addFlashAttribute("message","삭제 되었습니다.");
		
		
		return "redirect:/employee/vacation";
	}
	
	/* 휴가관리 제출하기 메소드  */
	@PostMapping("/vacation/detail/insert")
	public String detailInsertVacation(@ModelAttribute HolidayDTO holi, RedirectAttributes rttr) throws InsertException{
		
		employeeService.detailInsertVacation(holi);  // 제출하기 insert 쿼리문 로직
		
		employeeService.detailUpdateVacation(holi);  // 제출 여부 Y 로 업데이트 해주는 로직
		
		rttr.addFlashAttribute("message","제출 되었습니다.");
		
		
		return "redirect:/employee/vacation";
	}

	
	/* 휴가관리 제출하기 메소드  */
	@GetMapping("/updateVacationPy")
	public String updateVacationPy(HttpServletRequest request, RedirectAttributes rttr) throws InsertException{
		
		int no =  Integer.parseInt(request.getParameter("no"));
		String check = request.getParameter("yN");
		String yN = null;
		
		if(check.equals("Y")) {
			yN = "승인";
			rttr.addFlashAttribute("message","승인 되었습니다.");
		}else if(check.equals("N")){
			yN = "반려";
			rttr.addFlashAttribute("message","반려 되었습니다.");
		}

		
		try{ employeeService.updateVacationPy(no,yN);
		}catch (IllegalStateException e) {
            e.printStackTrace();}

		
		return "redirect:/employee/vacationSup";
	}
}
