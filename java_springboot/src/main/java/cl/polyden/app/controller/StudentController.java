package cl.polyden.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentController {
	
	@GetMapping({"/students", "/"})
	public String getAllStudents() {
		return "students";
	}

}
