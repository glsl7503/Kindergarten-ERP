package com.kindergarten.hi.item.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/item")
public class CompanyController {

	@GetMapping("/companymanagement")
	public String goCompanyManagement() {
		return "item/CompanyManagement";
	}

	@GetMapping("/companycreat")
	public String goCompanyCreat() {
		return "item/CompanyCreat";
	}

	@GetMapping("/companyupdate")
	public String CompanyUpdate() {
		return "item/CompanyUpdate";
	}
}
