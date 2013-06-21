package com.app.meibo.finace.report.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sqds.spring.annotation.GlobalAutowired;

@RequestMapping("/finace/report/*.html")
@Controller
@GlobalAutowired
public class ReportController {
	@RequestMapping
	public void index() {

	}
}
