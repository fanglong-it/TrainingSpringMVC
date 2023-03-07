package com.example.java.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.DataFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.java.model.Subject;
import com.example.java.pdf.SubjectPDFExport;
import com.example.java.service.AuthorityService;
import com.example.java.service.SubjectService;
import com.itextpdf.text.DocumentException;

@Controller
public class AdminController {

	private static final Logger logger = LogManager.getLogger("SubjectController");

	@Autowired
	AuthorityService authorityService;

	@RequestMapping("/admin/")
	public ModelAndView homePage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("ROLES", authorityService.getAllAuthorities());
		modelAndView.setViewName("admin");
		return modelAndView;
	}

	@RequestMapping("/admin/list")
	public String getusers() {

		return "admin";
	}

	@Autowired
	SubjectService subjectService;

	@RequestMapping(name = "/admin/manageSubject")
	public ModelAndView manageSubject(@RequestParam(name = "size", defaultValue = "5") int size,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "sortBy", defaultValue = "id") String sortBy,
			@RequestParam(name = "searchBy", defaultValue = "") String searchValue) {

		ModelAndView modelAndView = new ModelAndView();

		List<Subject> subjects = null;

		Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));

		if (searchValue.equals("") || searchValue.isEmpty()) {
			subjects = subjectService.getAllSubject(PageRequest.of(page, size, Sort.by(sortBy)));

		} else {
			subjects = subjectService.getAllSubjectByName(searchValue, pageable);
		}

		modelAndView.addObject("subjectList", subjects);

		int totalSub = subjectService.countTotalSubject();
		int totalPage = (int) Math.ceil((totalSub + size) / 4);

		modelAndView.addObject("totalPage", totalPage);
		modelAndView.addObject("page", page);
		modelAndView.addObject("size", size);
		modelAndView.addObject("sortBy", sortBy);
		modelAndView.addObject("searchBy", searchValue);

		modelAndView.setViewName("subject/manageSubject");
		return modelAndView;
	}

	@RequestMapping(value = "/admin/exportSubject", method = RequestMethod.GET)
	public ModelAndView getExcel() {
		List<Subject> subjects = subjectService.findAllSubject();

		logger.info("Start Export Excel!");

		return new ModelAndView("subjectListExcelView", "subjectList", subjects);
	}

	@RequestMapping(value = "/admin/exportPDF")
	public void exportToPDF(HttpServletResponse response) throws DocumentException, IOException {
		response.setContentType("application/pdf");
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String currentDateTime = dateFormat.format(new Date());

		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=subjects_" + currentDateTime + ".pdf";
		response.setHeader(headerKey, headerValue);

		List<Subject> subjects = subjectService.findAllSubject();

		SubjectPDFExport exporter = new SubjectPDFExport(subjects);
		exporter.export(response);
	}

}
