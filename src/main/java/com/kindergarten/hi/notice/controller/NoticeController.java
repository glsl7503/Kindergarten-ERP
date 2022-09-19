package com.kindergarten.hi.notice.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kindergarten.hi.common.paging.Pagenation;
import com.kindergarten.hi.common.paging.SelectCriteria;
import com.kindergarten.hi.login.model.dto.UserImpl;
import com.kindergarten.hi.notice.model.dto.NoticeDTO;
import com.kindergarten.hi.notice.model.dto.NoticeEmployeeDTO;
import com.kindergarten.hi.notice.model.service.NoticeService;

@Controller
@RequestMapping("/notice")
public class NoticeController {

	private final NoticeService noticeService;
	
	@Autowired
	public NoticeController(NoticeService noticeService) {
		this.noticeService = noticeService;
	}

	@GetMapping(value = "/list")
    public ModelAndView noticeList(HttpServletRequest request, ModelAndView mv) {

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

        /*
         * 전체 게시물 수가 필요하다.
         * 데이터베이스에서 먼저 전체 게시물 수를 조회해올 것이다.
         * 검색조건이 있는 경우 검색 조건에 맞는 전체 게시물 수를 조회한다.
         */
        int totalCount = noticeService.selectTotalCount(searchMap);
        /* 한 페이지에 보여 줄 게시물 수 */
        int limit = 5;		//얘도 파라미터로 전달받아도 된다.

        /* 한 번에 보여질 페이징 버튼의 갯수 */
        int buttonAmount = 5;

        /* 페이징 처리를 위한 로직 호출 후 페이징 처리에 관한 정보를 담고 있는 인스턴스를 반환받는다. */
        SelectCriteria selectCriteria = null;

        if(searchCondition != null && !"".equals(searchCondition)) {
            selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, searchCondition, searchValue);
        } else {
            selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount);
        }

        
        /* 조회해 온다 */
        List<NoticeDTO> noticeList = noticeService.selectNoticeList(selectCriteria);
        
        mv.addObject("noticeList", noticeList);
        mv.addObject("selectCriteria", selectCriteria);
        mv.setViewName("notice/notice");

        return mv;
    }
//	@GetMapping("/list")
//	public String golist() {
//		
//		return "notice/notice";
//	}
	
	@GetMapping("/goregist")
	public ModelAndView goregist(@AuthenticationPrincipal UserImpl user, ModelAndView mv, HttpServletRequest request) {
		String username = user.getEmpName();
		
		mv.addObject("empName", username);
		mv.setViewName("notice/regist");
		
		return mv;
	}
	
	@PostMapping("/goregist")
	public String goregist(@AuthenticationPrincipal UserImpl user, @ModelAttribute NoticeDTO noticeDTO, 
			               RedirectAttributes rttr) {
		System.out.println(noticeDTO);
		int no = user.getEmpNo();
		noticeDTO.setNo(no);
		int result = noticeService.registNotice(noticeDTO);
		rttr.addAttribute(result);
		
		return "redirect:/notice/list";
	}
	
	@GetMapping("/godetail")
	public ModelAndView godetail(HttpServletRequest request, @ModelAttribute NoticeDTO noticeDTO, 
			                     ModelAndView mv, @AuthenticationPrincipal UserImpl user) {
		String username = user.getEmpName();
		Long no = Long.valueOf(request.getParameter("no"));
        NoticeDTO noticeDetail = noticeService.selectNoticeDetail(no);

        mv.addObject("no", no);
        mv.addObject("empName", username);
        mv.addObject("notice", noticeDetail);
        mv.setViewName("notice/detail");
		
		return mv;
	}
	
//	@PostMapping("/godetail")
//	public String godetail() {
//		
//		return "";
//	}
	
	@GetMapping("/goupdate")
	public ModelAndView goupdate(@AuthenticationPrincipal UserImpl user, ModelAndView mv, HttpServletRequest request) {
		Long no = Long.valueOf(request.getParameter("no"));
		NoticeDTO noticeDetail = noticeService.selectNoticeDetail(no);
		String username = user.getEmpName();
		mv.addObject("no", no);
		mv.addObject("empName", username);
		mv.setViewName("notice/update");
		
		return mv;
	}
	
	@PostMapping("/afterupdate")
	public String goupdate(@ModelAttribute NoticeDTO noticeDTO, RedirectAttributes rttr) {
		System.out.println("notice 값 : " + noticeDTO);
		int result = noticeService.updateNotice(noticeDTO);
		
		return "redirect:/notice/godetail?no=" + noticeDTO.getNoticeNo();
	}
	
	@GetMapping("/godelete")
	public String godelete(HttpServletRequest request, RedirectAttributes rttr) {
		
		int no = Integer.parseInt(request.getParameter("no"));
		int result = noticeService.deleteNotice(no);
		
		return "redirect:/notice/list";
	}
}