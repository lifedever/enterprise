package com.app.meibo.operationalPart.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sqds.spring.annotation.GlobalAutowired;

@Controller
@GlobalAutowired
@RequestMapping("/meibo/operationalPart/*.html")
public class OperationalPartController {
	@RequestMapping
	public void index() {

	}
}
