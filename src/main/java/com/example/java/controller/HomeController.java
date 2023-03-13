package com.example.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.java.service.SubjectService;

@Controller
public class HomeController {

	@Autowired
	SubjectService subjectService;

	@RequestMapping("/")
	public String welcomePage() {
		return "welcomePage";
	}

}
