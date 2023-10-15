package cl.polyden.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import cl.polyden.app.entitys.Student;


@Controller
public class StudentController {
  
  
  @GetMapping({"/students", "/"})
  public String getAllStudents() {
    return "students";
  }
 
  @GetMapping({"/students/new"})
  public String createStudentFormString(Model model) {
	  Student student = new Student();
	  model.addAttribute("student", student);
	  
    return "create-student";
  }
  
  @PostMapping("/students")
  public String saveStudent(@ModelAttribute("student") Student student) {
	  return "redirect:/students";
  }
}