package com.kindergarten.hi.item.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kindergarten.hi.common.paging.Pagenation;
import com.kindergarten.hi.common.paging.SelectCriteria;
import com.kindergarten.hi.food.controller.DeleteException;
import com.kindergarten.hi.item.model.dto.ItemDTO;
import com.kindergarten.hi.item.model.dto.ItemManagementHisDTO;
import com.kindergarten.hi.item.model.service.ItemService;

@Controller
@RequestMapping("/item")
public class ItemController {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	private final ItemService itemService;

	public ItemController(ItemService itemService) {

		this.itemService = itemService;
	}

	/* 전체조회 */
	@GetMapping("/itemmanagement")
	public ModelAndView goItemmanageMent(HttpServletRequest request, ModelAndView mv) {
		log.info("");
		log.info("");
		log.info("[ItemController] ========================================");

		String currentPage = request.getParameter("currentPage");
		int pageNo = 1;

		if (currentPage != null && !"".equals(currentPage)) {
			pageNo = Integer.parseInt(currentPage);
		}

		String searchCondition = request.getParameter("searchCondition");
		String searchValue = request.getParameter("searchValue");

		Map<String, String> searchMap = new HashMap<>();
		searchMap.put("searchCondition", searchCondition);
		searchMap.put("searchValue", searchValue);

		log.info("[ItemController] 컨트롤러에서 검색조건 확인하기 : " + searchMap);

		int totalCount = itemService.selectTotalCount(searchMap);
		log.info("[ItemController] totalItemCount : " + totalCount);

		int limit = 3;

		int buttonAmount = 5;

		SelectCriteria selectCriteria = null;

		if (searchCondition != null && !"".equals(searchCondition)) {
			selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, searchCondition,
					searchValue);
		} else {
			selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount);
		}

		log.info("[ItemController] selectCriteria : " + selectCriteria);

		List<ItemDTO> itemList = itemService.selectItemList(selectCriteria);

		mv.addObject("selectCriteria", selectCriteria);
		mv.addObject("itemList", itemList);
		mv.setViewName("item/itemManagement");

		return mv;

	}

	/* 상세조회 */
	@GetMapping("/itemmanagementdetail")
	public ModelAndView goitemManagementDetail(HttpServletRequest request, ModelAndView mv) {
		log.info("");
		log.info("");
		log.info("[ItemController] ===================================================");

		Long itemNo = Long.valueOf(request.getParameter("itemNo"));

		log.info("[ItemController] goitemManagementDetail itemNo : " + itemNo);

		ItemDTO itemDetail = itemService.goitemManagementDetail(itemNo);
		ItemManagementHisDTO itemHisDetail = itemService.goitemManagementHisDetail(itemNo);
		System.out.println("조회 : " + itemDetail);

		mv.addObject("itemDetail", itemDetail);
		mv.addObject("itemHisDetail", itemHisDetail);
		mv.setViewName("/item/itemManagementDetail");

		return mv;

	}

	/* 삭제하기 */
	@PostMapping("/itemmanagementdetail/delete")
	public String goItemDelete(RedirectAttributes rttr, @ModelAttribute ItemDTO item) throws DeleteException{
		
		System.out.println("item 조회 : " + item);
		
		itemService.goItemDelete(item);

//		rttr.addFlashAttribute("message", "수정 되었습니다.");

		return "redirect:/item/itemmanagement";

	}
//
//	@GetMapping("/itemcreat")
//	public String goItemCreat() {
//		return "item/itemCreat";
//	}

//	@GetMapping("/itemupdate")
//	public String goitemUpdate() {
//		return "item/itemUpdate"; 
//	}

}
