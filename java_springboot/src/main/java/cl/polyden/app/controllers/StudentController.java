package cl.polyden.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import cl.polyden.app.entitys.Student;


@Controller
public class StudentController {
  
  
  @GetMapping({"/students", "/"})
  public String getAllStudents() {
    return "students";
  }
 
  @GetMapping("/students/new")
  public String createStudentForm(Model model) {
	  Student student = new Student();
	  model.addAttribute("student", student);
	  
    return "create-student"; // create-student.html
  }
  

}