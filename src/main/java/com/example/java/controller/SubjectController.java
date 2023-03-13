package com.example.java.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.java.service.SubjectService;

@Controller
public class SubjectController {
	private static final Logger logger = LogManager.getLogger("SubjectController");
	@Autowired
	SubjectService subjectService;

	@RequestMapping("/subjects")
	public ModelAndView getListSubject(@RequestParam(name = "index", defaultValue = "0") int index,
			@RequestParam(name = "size", defaultValue = "6") int size,
			@RequestParam(name = "sortBy", defaultValue = "id") String sortBy) {
		ModelAndView modelAndView = new ModelAndView();
		if (index == 0) {
			index = 0;
		}
		if (size == 0) {
			size = 6;
		}
		Pageable pageable = PageRequest.of(index, size, Sort.by(sortBy));
		modelAndView.addObject("subjects", subjectService.getAllSubject(pageable));

		int totalSub = subjectService.countTotalSubject();
		int totalPage = (int) Math.ceil((totalSub + size) / 4);

		modelAndView.addObject("totalPage", totalPage);
		modelAndView.addObject("index", index);
		modelAndView.addObject("size", size);

		modelAndView.setViewName("subject");
		return modelAndView;
	}

	@RequestMapping("/restSubjects")
	public ModelAndView getRestSubject() {
		return new ModelAndView("rest/subject");
	}
}
