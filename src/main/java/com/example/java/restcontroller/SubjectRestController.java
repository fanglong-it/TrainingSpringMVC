package com.example.java.restcontroller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.java.model.Subject;
import com.example.java.service.SubjectService;

@RestController
@RequestMapping("/rest")
public class SubjectRestController {

	@Autowired
	SubjectService subjectService;

//

	@GetMapping(value = "/getSubjects")
	public ResponseEntity<List<Subject>> getSubjectList() {
		return new ResponseEntity<List<Subject>>(subjectService.findAllSubject(), HttpStatus.OK);
	}
}
