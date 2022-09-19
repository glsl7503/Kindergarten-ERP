//package com.kindergarten.hi.employee.controller;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;
//
//import com.kindergarten.hi.common.paging.Pagenation;
//import com.kindergarten.hi.common.paging.SelectCriteria;
//import com.kindergarten.hi.employee.model.service.VacationService;
//import com.kindergarten.hi.employee.model.service.VacationServiceImp;
//import com.kindergarten.hi.student.model.dto.StudentDTO;
//@Controller
//@RequestMapping("/employee")
//public class VacationController {
//	 private final Logger log = LoggerFactory.getLogger(this.getClass());
//	    private final VacationService vacationService;
//	    
//	    public VacationController (VacationService vacationService) {
//	    	
//	    	this.vacationService = vacationService;
//	    }
//	
//	@GetMapping("/VacationSelect")
//	public ModelAndView VacationSelect(HttpServletRequest request, ModelAndView mv) {
//		log.info("");
//        log.info("");
//        log.info("[StudentController] =========================================================");
//        String currentPage = request.getParameter("currentPage");
//        int pageNo = 1;
//
//        if(currentPage != null && !"".equals(currentPage)) {
//            pageNo = Integer.parseInt(currentPage);
//        }
//
//        String searchCondition = request.getParameter("searchCondition");
//        String searchValue = request.getParameter("searchValue");
//
//        Map<String, String> searchMap = new HashMap<>();
//        searchMap.put("searchCondition", searchCondition);
//        searchMap.put("searchValue", searchValue);
//
//        log.info("[BoardController] 컨트롤러에서 검색조건 확인하기 : " + searchMap);
//
//        /*
//         * 전체 게시물 수가 필요하다.
//         * 데이터베이스에서 먼저 전체 게시물 수를 조회해올 것이다.
//         * 검색조건이 있는 경우 검색 조건에 맞는 전체 게시물 수를 조회한다.
//         */
//        int totalCount = vacationService.selectTotalCount(searchMap);
//        log.info("[BoardController] totalBoardCount : " + totalCount);
//
//        /* 한 페이지에 보여 줄 게시물 수 */
//        int limit = 10;		//얘도 파라미터로 전달받아도 된다.
//
//        /* 한 번에 보여질 페이징 버튼의 갯수 */
//        int buttonAmount = 5;
//
//        /* 페이징 처리를 위한 로직 호출 후 페이징 처리에 관한 정보를 담고 있는 인스턴스를 반환받는다. */
//        SelectCriteria selectCriteria = null;
//
//        if(searchCondition != null && !"".equals(searchCondition)) {
//            selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, searchCondition, searchValue);
//        } else {
//            selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount);
//        }
//
//        log.info("[BoardController] selectCriteria : " + searchCondition);
//
//        List<StudentDTO> goVacationList = vacationService.selectAllStudentListt(selectCriteria);
//        log.info("[StudentController] goStudentList : " + goVacationList);
//        
//        mv.addObject("goVacationList", goVacationList);
//        mv.addObject("selectCriteria", selectCriteria);
//		mv.setViewName("/employee/VacationSelect");
//		
//		log.info("[StudentController] =========================================================");
//		
//		return mv;
//	}
//	
//	
//	
//
//}
