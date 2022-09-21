package com.kindergarten.hi.food.controller;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.kindergarten.hi.food.model.dto.CalenderDTO;
import com.kindergarten.hi.food.model.dto.FoodDTO;
import com.kindergarten.hi.food.model.dto.FoodEmployeeDTO;
import com.kindergarten.hi.food.model.dto.TraderDTO;
import com.kindergarten.hi.food.model.service.FoodService;

@Controller
@RequestMapping("/food")
public class FoodController {
	
	private final FoodService foodService;
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	
	public FoodController(FoodService foodService) {
		
		this.foodService = foodService;
	}
	
	/* s:Stock Controller */
	
	/* 음식품목재고 조회 페이지 메소드  */
	@GetMapping("/stock")
	public ModelAndView selectStockList(ModelAndView mv, HttpServletRequest request) {

		/*
         * 목록보기를 눌렀을 시 가장 처음에 보여지는 페이지는 1페이지이다.
         * 파라미터로 전달되는 페이지가 있는 경우 currentPage는 파라미터로 전달받은 페이지 수 이다.
         */
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

        Map<String, String> searchMap = new HashMap<>();
        searchMap.put("searchCondition", searchCondition);
        searchMap.put("searchValue", searchValue);

        log.info("[FoodController] 컨트롤러에서 검색조건 확인하기 : " + searchMap);

        /*
         * 전체 게시물 수가 필요하다.
         * 데이터베이스에서 먼저 전체 게시물 수를 조회해올 것이다.
         * 검색조건이 있는 경우 검색 조건에 맞는 전체 게시물 수를 조회한다.
         */
        int totalCount = foodService.selectTotalCount(searchMap);
        log.info("[FoodController] totalFoodCount : " + totalCount);

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

        log.info("[FoodController] selectCriteria : " + selectCriteria);

		List<FoodDTO> foodList = foodService.selectFoodStockList(selectCriteria);
		
		log.info("foodList : " + foodList);
		
		mv.addObject("selectCriteria", selectCriteria);
		mv.addObject("foodList",foodList);
		mv.setViewName("/food/food_stock");
		
		return mv;
	}
	
	/* 음식품목재고 등록 페이지 메소드  */
	@GetMapping("/stock/insert")
	public ModelAndView foodStockInsert(ModelAndView mv) {
		
		mv.setViewName("/food/food_stock_insert");
		
		return mv;
	}
	
	/* 음식품목재고 등록하기 메소드  */
	@PostMapping("/stock/insert")
	public String insertFoodStock(@ModelAttribute FoodDTO food, RedirectAttributes rttr) throws InsertException{

		log.info("");
		log.info("");

		System.out.println("food : " + food);
		
		foodService.insertFoodStock(food);

		rttr.addFlashAttribute("message", "등록되었습니다.");
		
		return "redirect:/food/stock";
	}
	
	/* 음식품목재고 상세조회 메소드 */
	@GetMapping("/stock/detail")
	public String selectStockDetail(HttpServletRequest request, Model model) {
		System.out.println("컨트롤러 오는거 확인! ");
		 log.info("");
	     log.info("");
	     log.info("[FoodStockController] =============================================================================");

	     Long no = Long.valueOf(request.getParameter("no"));
	     
	     log.info("[FoodStockController] selectFoodStockDetail No : " + no);

        FoodDTO foodDetail = foodService.selectStockDetail(no);
        
        System.out.println("foodDetail : " + foodDetail);
        
        model.addAttribute("stock", foodDetail);
        model.addAttribute("no",no);

        log.info("[FoodStockController] selectFoodStockDetail =========================================================");

        return "food/food_stock_detail";
	}
	
	/* 음식품목재고 수정하기 메소드 */
	@PostMapping("/stock/update")
	public String updateStock(@ModelAttribute FoodDTO food, RedirectAttributes rttr) throws UpdateException{
		
		log.info("");
		log.info("");
		log.info("[updateStockController] 들어옴 s: =================================");

		System.out.println("food : " + food);

		foodService.updateStock(food);

		rttr.addFlashAttribute("message","게시글이 수정 되었습니다.");
		
		log.info("[updateStockController] end : ==========================================");
		
		return "redirect:/food/stock";
	}
	
	/* 음식품목재고 삭제하기 메소드 */
	@PostMapping("/stock/delete")
	public String deteleStock(@ModelAttribute FoodDTO food, RedirectAttributes rttr) throws DeleteException{
		
		log.info("");
		log.info("");
		log.info("[deteleStockController] 들어옴 s: =================================");
		
		System.out.println("food : " + food);
		
		foodService.deleteStock(food);
		
		rttr.addFlashAttribute("message","게시글이 삭제 되었습니다.");
		
		log.info("[deteleStockController] end : =================================");
		
		return "redirect:/food/stock";
	}
	/* e:음식품목재고 Controller */
	
	/* 거래업체 컨트롤러 시작 */
	
	/* 거래업체 리스트 조회 및 페이징 메소드 */
	@GetMapping("/trader")
	public ModelAndView selectTraderList(ModelAndView mv, HttpServletRequest request) {
		
		log.info("");
		log.info("");
		log.info("[selectTraderList] 시작 ======================================");
		
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

        Map<String, String> searchMap = new HashMap<>();
        searchMap.put("searchCondition", searchCondition);
        searchMap.put("searchValue", searchValue);

        int totalCount = foodService.selectTraderTotalCount(searchMap);
        log.info("[TraderController] totalTraderCount : " + totalCount);

        int limit = 10;		

        int buttonAmount = 5;

        com.kindergarten.hi.common.paging.SelectCriteria selectCriteria = null;

        if(searchCondition != null && !"".equals(searchCondition)) {
            selectCriteria = com.kindergarten.hi.common.paging.Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, searchCondition, searchValue);
        } else {
            selectCriteria = com.kindergarten.hi.common.paging.Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount);
        }

		List<TraderDTO> traderList = foodService.selectTraderList(selectCriteria);
		
		
		log.info("traderList : " + traderList);
		log.info("===========================================================");
		
		mv.addObject("selectCriteria", selectCriteria);
		mv.addObject("traderList",traderList);
		mv.setViewName("food/food_trader");
		
		return mv;
	}

	/* 거래업체 등록 페이지 메소드 */
	@GetMapping("/trader/insert")
	public ModelAndView insertTraberPage(ModelAndView mv) {
		
		System.out.println("insertTraber");
		
		mv.setViewName("/food/food_trader_insert");
		
		return mv;
	}
	
	/* 거래업체 등록하기 메소드 */
	@PostMapping("/trader/insert")
	public String insertTrader(@ModelAttribute TraderDTO trader, RedirectAttributes rttr) throws InsertException{
		
		log.info("");
		log.info("");
		log.info("[insertTraderController] =======================================");

		System.out.println("trader : " + trader);
		
		foodService.insertTrader(trader);

		rttr.addFlashAttribute("message", "등록되었습니다.");
		
		return "redirect:/food/trader";
	}
	
	/* 거래업체 상세조회 메소드 */
	@GetMapping("/trader/detail")
	public String selectTraderDetail(HttpServletRequest request, Model model) {
		
		log.info("");
		log.info("");
		log.info("[selectTraderDetailController] ===================================");
		
		Long no = Long.valueOf(request.getParameter("no"));
		
		log.info("[selectTraderDetailController] No : " + no);

		TraderDTO trader = foodService.selectTraderDetail(no);
		
		model.addAttribute("trader", trader);
		
		return "food/food_trader_detail";
	}
	
	/* 거래업체 수정하기 메소드 */
	@PostMapping("/trader/update")
	public String updateTrader(@ModelAttribute TraderDTO trader, RedirectAttributes rttr) throws UpdateException{
		
		log.info("");
		log.info("");
		log.info("[updateTraderController] 들어옴 s: ===============================================");

		System.out.println("trader : " + trader);
		
		foodService.updateTrader(trader);

		rttr.addFlashAttribute("message","수정이 완료 되었습니다.");
		
		log.info("[updateTraderController] end : =================================================");
		
		return "redirect:/food/trader";
	}
	
	/* 거래업체 삭제하기 메소드 */
	@PostMapping("/trader/delete")
	public String deleteTrader(@ModelAttribute TraderDTO trader, RedirectAttributes rttr) throws DeleteException {
		
		log.info("");
		log.info("");
		log.info("[deleteTraderController] 시작 : =============================================");
		
		System.out.println("trader : " + trader);
		
		foodService.deleteTrader(trader);
		
		rttr.addFlashAttribute("message", "삭제가 완료 되었씁니다.");
		
		return "redirect:/food/trader";
	}
	
	/* e:Food Traber Controller */	

	/* 캘린더 시작 */
	
	/* 캘린더 조회하기 */
	@GetMapping("/calender")
	public String selectCalender() {
		
		return "/food/food_calender";
	}
	
	/* 캘린더 ajax 리스트 조회하기 */
	@ResponseBody
	@GetMapping(value="/list", produces = "application/json; charset=utf-8")
	public String selectCalenderList() {
		
		log.info("");
        log.info("");
        log.info("[CalendarController] 시작 : =========================================================");
		
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        
        List<CalenderDTO> calenderList = foodService.selectCalenderList();
        
        log.info("[CalendarController] : " + gson.toJson(calenderList));
        log.info("[CalendarController] 끝 : =========================================================");
        
		
		return gson.toJson(calenderList);
	}
	
	/* 캘린더 수정하기 메소드 */
	@PostMapping("/calender/update")
	public String updateCalender(@ModelAttribute CalenderDTO calender, RedirectAttributes rttr) throws UpdateException{
		
		log.info("");
		log.info("");
		log.info("[updateConalender] 시작 : =================================================");
		log.info("calender 확인 : " + calender);
		foodService.updateCalender(calender);
		
		log.info("[updateConalender] 끝 : =================================================");
		
		rttr.addFlashAttribute("message", "수정이 완료 되었습니다.");
		
		return "redirect:/food/calender";
	}
	
	/* 캘린더 삭제하기 메소드 */
	@PostMapping("/calender/delete")
	public String deleteCalender(@ModelAttribute CalenderDTO calender, RedirectAttributes rttr) throws DeleteException {
		
		log.info("");
		log.info("");
		log.info("[deleteConalender] 시작 : =================================================");
	
		System.out.println("calender 확인 : " + calender);
		
		foodService.deleteCalender(calender);
		
		log.info("[deleteConalender] 끝 : =================================================");
		
		rttr.addFlashAttribute("message", "삭제가 완료 되었씁니다.");
		
		return "redirect:/food/calender";
	}
	
	/* 캘린더 카테고리 조회 ajax */
	@ResponseBody
	@PostMapping(value="/calender/category", produces = "application/json; charset=utf-8")
	public String calenderCategory() {
		
		List<FoodEmployeeDTO> empList = foodService.calenderCategoryEmp();
		
		System.out.println("empList : " + empList);
		
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		JsonObject jsonObject = new JsonObject();
		
		String str_empList = gson.toJson(empList);
		
		jsonObject.addProperty("empList", str_empList);
		
		String data = gson.toJson(jsonObject);
		
		return data;
	}
	
	/* 캘린더 추가하기 메소드 */
	@PostMapping("/calender/insert")
	public String insertCalender(@ModelAttribute CalenderDTO calender, RedirectAttributes rttr) throws InsertException {
		
		log.info("");
		log.info("");
		log.info("[insertConalender] 시작 : =================================================");
		log.info("calender 확인 : " + calender);
		
		foodService.insertCalender(calender);
		
		log.info("[insertConalender] 끝 : =================================================");
		
		rttr.addFlashAttribute("message", "식단표 추가 완료되었습니다.");
		
		return "redirect:/food/calender";
	}
	
	/* 캘린더 끄읕~ */
	
	
	
	
	
	
	
	
	
	
}