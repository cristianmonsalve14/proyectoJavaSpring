package cl.polyden.app.controllers;





import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import cl.polyden.app.entitys.Student;
import cl.polyden.app.services.IStudentService;


@Controller
public class StudentController {
  
  private final IStudentService service;
private String  id;
  
  @Autowired
  public StudentController(IStudentService service) {
	  this.service = service;
  }
	
  @GetMapping({"/students", "/"})
  public String getAllStudents(Model model) {
	  model.addAttribute("students", service.listAllStudents());
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
	  service.saveStudent(student);
	  return "redirect:/students";
  }
  
  @GetMapping("/students/edit/{id}")
  public String showFormEditStudent(@PathVariable Long Id, @ModelAttribute("student") Student student, Model model) {
	 Optional<Student> optionalStudent = service.getStudentById(Id);
	 
	 if(!optionalStudent.isPresent()) {
		 throw new StudentNotFoundException("no se encontro un estudiante con ese id: "+ id);
	 }
	 return ""; 
  }
}

class StudentNotFoundException extends RuntimeException {
	public StudentNotFoundException(String message) {
		super(message);
	}
}