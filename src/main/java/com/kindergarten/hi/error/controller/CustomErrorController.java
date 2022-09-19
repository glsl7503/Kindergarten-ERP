package com.kindergarten.hi.error.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class CustomErrorController implements ErrorController {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	// 에러 페이지 정의
	private final String ERROR_404_PAGE_PATH = "/error/404";
	private final String ERROR_500_PAGE_PATH = "/error/500";
	private final String ERROR_ETC_PAGE_PATH = "/error/error";

    @RequestMapping(value = "/error")
    public String handleError(HttpServletRequest request) {
    	
    	// 에러 코드 획득
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        
        
        if(status != null){
        	// 에러 코드에 대한 상태 정보
            int statusCode = Integer.valueOf(status.toString());
            
            // 로그로 상태값을 기록 및 출력
            log.info("statusCode : " + statusCode);
            
            // 404 error
 			if (statusCode == HttpStatus.NOT_FOUND.value()) {
 				log.info("404 : " + statusCode);
 				return ERROR_404_PAGE_PATH;
 			}
            
            // 500 error
 			if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
 				log.info("500 : " + statusCode);
 				return ERROR_500_PAGE_PATH;
 			}

        }
        return ERROR_ETC_PAGE_PATH;
    }
    
}
