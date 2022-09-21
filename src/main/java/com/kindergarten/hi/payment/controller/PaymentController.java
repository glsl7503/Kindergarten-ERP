package com.kindergarten.hi.payment.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kindergarten.hi.common.paging.Pagenation;
import com.kindergarten.hi.common.paging.SelectCriteria;
import com.kindergarten.hi.login.model.dto.UserImpl;
import com.kindergarten.hi.payment.model.dto.PaymentDTO;
import com.kindergarten.hi.payment.model.dto.PaymentFileDTO;
import com.kindergarten.hi.payment.model.serivce.PaymentService;


@Controller
@RequestMapping("/payment")
public class PaymentController {
	
    @Value("${image.image-dir}")
    private String IMAGE_DIR;
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	private final PaymentService service;
	
	@Autowired
	public PaymentController(PaymentService service) {
		
		this.service = service;
	}
		// 리스트조회
	@GetMapping("/spendlist")
	public ModelAndView paymentList(HttpServletRequest request, ModelAndView mv,@AuthenticationPrincipal UserImpl user) {
		 log.info("");
	     log.info("");
	     log.info("[paymentController] =========================================================");
		/*
         * 목록보기를 눌렀을 시 가장 처음에 보여지는 페이지는 1페이지이다.
         * 파라미터로 전달되는 페이지가 있는 경우 currentPage는 파라미터로 전달받은 페이지 수 이다.
         */
	    
        String currentPage = request.getParameter("currentPage");
        int pageNo = 1;

        if(currentPage != null && !"".equals(currentPage)) {
            pageNo = Integer.parseInt(currentPage);
        }
        if(pageNo==0) {
        	pageNo=1;
        }

        String searchCondition = request.getParameter("searchCondition");
        String searchValue = request.getParameter("searchValue");
        
        String userNo = null;
        Map<String, String> searchMap = new HashMap<>();
        
        int status = user.getLoginEmployeeRoleList().get(0).getAuthorityCode(); //권한조회
        
        if(status !=3) {
        userNo = Integer.toString(user.getEmpNo());
        }
        
        searchMap.put("searchCondition", searchCondition);
        searchMap.put("searchValue", searchValue);
        searchMap.put("userNo", userNo);
        
        log.info("[paymentController] 컨트롤러에서 검색조건 확인하기 : " + searchMap);
        
        /*
         * 전체 게시물 수가 필요하다.
         * 데이터베이스에서 먼저 전체 게시물 수를 조회해올 것이다.
         * 검색조건이 있는 경우 검색 조건에 맞는 전체 게시물 수를 조회한다.
         */
        int totalCount = service.selectTotalCount(searchMap);
        log.info("[paymentController] totalBoardCount : " + totalCount);

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

        log.info("[paymentController] selectCriteria : " + selectCriteria);

        /* 조회해 온다 */
        List<PaymentDTO> spendList = service.selectSpendList(selectCriteria,userNo);
        
        log.info("[PaymentController] spendList : " + spendList);

        mv.addObject("spendList", spendList);
        mv.addObject("selectCriteria", selectCriteria);
        log.info("[PaymentController] SelectCriteria : " + selectCriteria);
        mv.setViewName("payment/spendTable");

        log.info("[paymentController] =========================================================");
		
		
		return mv;
	}
	
	
	
	@GetMapping("/spendsubmit")
	public String spendsubmit() {
		
		
		return "payment/spendsubmit";
	}
	
	
	@PostMapping("/spendsubmit")
	public String spendsubmitForm(@ModelAttribute PaymentDTO payment, HttpServletRequest request,
            @RequestParam("img1") MultipartFile img1, RedirectAttributes rttr) throws FileNotFoundException {
		
		  log.info("");
	        log.info("");
	        log.info("[paymentController] =========================================================");
	        String rootLocation = ResourceUtils.getURL("src/main/resources").getPath();
	        
	       // String rootLocation = request.getSession().getServletContext().getRealPath("/resources");
//	        String rootLocation = IMAGE_DIR;
	        
	        log.info("[paymentController] ======== rootLocation: "+ rootLocation);

	        String fileUploadDirectory = rootLocation + "/static/fileupload/payment";

	        log.info("[paymentController] ========fileUploadDirectory:"+ fileUploadDirectory);

	        File directory = new File(fileUploadDirectory);


	        log.info("[paymentController] fileUploadDirectory : " + directory);


	        /* 파일 저장경로가 존재하지 않는 경우 디렉토리를 생성한다. */
	        if (!directory.exists() ) {

	            /* 폴더를 한 개만 생성할거면 mkdir, 상위 폴더도 존재하지 않으면 한 번에 생성하란 의미로 mkdirs를 이용한다. */
	            log.info("[paymentController] 폴더 생성 : " + directory.mkdirs());
	         
	        }

	        /* 업르도 파일 하나하나에 대한 정보를 담을 리스트 */
	        List<Map<String, String>> fileList = new ArrayList<>();

	        List<MultipartFile> paramFileList = new ArrayList<>();
	        paramFileList.add(img1);
	        log.info("[paymentController] Img1 : " + img1);
	    
	        try {
	            for (MultipartFile paramFile : paramFileList) {
	                if (paramFile.getSize() > 0) {
	                    String originFileName = paramFile.getOriginalFilename();

	                    log.info("[paymentController] originFileName : " + originFileName);

	                    String ext = originFileName.substring(originFileName.lastIndexOf("."));
	                    String savedFileName = UUID.randomUUID().toString().replace("-", "") + ext;

	                    log.info("[paymentController] 변경한 이름 : " + savedFileName);

	                    log.info("[paymentController] paramFile : " + fileUploadDirectory + "/" + savedFileName);
	                    paramFile.transferTo(new File(fileUploadDirectory + "/" + savedFileName));

	                    /* DB에 업로드한 파일의 정보를 저장하는 비지니스 로직 수행 */
	                    /* 필요한 정보를 Map에 담는다. */
	                    Map<String, String> fileMap = new HashMap<>();
	                    fileMap.put("originFileName", originFileName);
	                    fileMap.put("savedFileName", savedFileName);
	                    fileMap.put("savePath", fileUploadDirectory);



	                    String fieldName = paramFile.getName();
	                    log.info("[paymentController] 필드 name : " + fieldName);

	
	                    fileList.add(fileMap);
	                }
	            }

	            log.info("[paymentController] fileList : " + fileList);

	            /* 서비스를 요청할 수 있도록 BoardDTO에 담는다. */


	            List<PaymentFileDTO> list = new ArrayList<PaymentFileDTO>();
	            for (int i = 0; i < fileList.size(); i++) {
	                Map<String, String> file = fileList.get(i);

	                PaymentFileDTO tempFileInfo = new PaymentFileDTO();
	                tempFileInfo.setOriginName(file.get("originFileName"));
	                tempFileInfo.setSavedName(file.get("savedFileName"));
	                tempFileInfo.setMainPath(file.get("savePath"));

	                list.add(tempFileInfo);
	            }
	            
	            service.insertPaymentSubmit(payment, list);
	            
	            rttr.addFlashAttribute("message", "등록에 성공하셨습니다.");

	        } catch (IllegalStateException | IOException e) {
	            e.printStackTrace();

	            /* 어떤 종류의 Exception이 발생 하더라도실패 시 파일을 삭제해야 한다. */
	            int cnt = 0;
	            for (int i = 0; i < fileList.size(); i++) {
	                Map<String, String> file = fileList.get(i);

	                File deleteFile = new File(fileUploadDirectory + "/" + file.get("savedFileName"));
	                boolean isDeleted1 = deleteFile.delete();

	                if (isDeleted1) {
	                    cnt++;
	                }
	            }

	            if (cnt == fileList.size()) {
	                log.info("[paymentController] 업로드에 실패한 모든 사진 삭제 완료!");
	                e.printStackTrace();
	            } else {
	                e.printStackTrace();
	            }
	        }

	        log.info("[paymentController] =========================================================");

		
		
		return "redirect:/payment/spendlist";
	}
	
	@GetMapping("/spenddetail")
	public ModelAndView spendDetail(HttpServletRequest request, ModelAndView mv,@AuthenticationPrincipal UserImpl user) {
		
		int no =  Integer.parseInt(request.getParameter("no"));
		int status = user.getLoginEmployeeRoleList().get(0).getAuthorityCode();
		String statusName = null;
		
		PaymentDTO detail = service.paymentDetail(no);
		PaymentFileDTO file = service.selectPaymentFile(no);
		
		 if(status ==3) {
			 statusName = "a";
		        }
		 
		mv.addObject("status", statusName);
		mv.addObject("spend", detail);
		mv.addObject("file", file);
		
		mv.setViewName("payment/spenddetail");
		
		return mv;
	}
	
	
	@GetMapping("/spendupdate")
	public ModelAndView spendUpdate(HttpServletRequest request,ModelAndView mv) {
		
		int no =  Integer.parseInt(request.getParameter("no"));
		PaymentDTO detail = service.paymentDetail(no);
		mv.addObject("spend", detail);
		mv.setViewName("payment/spendupdate");
		
		return mv;
	}
	
	@PostMapping("/spendupdate")
	public String spendUpdateForm(@ModelAttribute PaymentDTO payment,RedirectAttributes rttr) throws IOException {
		
		
		try {
			 service.updatePayment(payment);
		} catch (IllegalStateException e) {
	            e.printStackTrace();}
		
		return  "redirect:/payment/spendlist";
	}
	
	@GetMapping("/spenddelete")
	public String spenddelete(HttpServletRequest request) {
		
		int no =  Integer.parseInt(request.getParameter("no"));
		
		try{service.deletePayment(no);}
		catch (IllegalStateException e) {
            e.printStackTrace();}
		
		return "redirect:/payment/spendlist";
	}
	
	
	
	@GetMapping("/spendsubmitToSup")
	public String spendsubmitFormToSup(HttpServletRequest request) {
		
		int no =  Integer.parseInt(request.getParameter("no"));
		
		try{service.updatePaymentToSup(no);
		}
		catch (IllegalStateException e) {
            e.printStackTrace();}
		
		return "redirect:/payment/spendlist";
	}
	@GetMapping("/spendSupFinal")
	public String spendSupFinal(HttpServletRequest request) {
		
		int no =  Integer.parseInt(request.getParameter("no"));
		String check = request.getParameter("yN");
		String yN = null;
		
		if(check.equals("Y")) {
			yN = "승인";
		}else if(check.equals("N")){
			yN = "반려";
		}
		
		try{service.updatePaymentFinal(no,yN);
		}
		catch (IllegalStateException e) {
            e.printStackTrace();}
		
		return "redirect:/payment/spendlist";
	}
	
}
