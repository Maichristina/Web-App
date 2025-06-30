package soft_eng_demo.sbparent;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@Autowired
	public StudentController(StudentService theStudentService) {
		studentService = theStudentService;
	}
		
	@RequestMapping("/list")
	public String listStudent(Model theModel) {
		
		List<Student> theStudent = studentService.findAll();
		
		theModel.addAttribute("student", theStudent);
		
		return "student";
	}
	
	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		Student theStudent= new Student();
		
		theModel.addAttribute("student", theStudent);
		
		return "student-form";
	}


	@RequestMapping("/save")
	public String saveStudent(@ModelAttribute("student") Student theStudent, Model theModel) {
		
		studentService.save(theStudent);
		
		return "redirect:/student/list";
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam("id") int id) {
		
		studentService.deleteById(id);

		return "redirect:/student/list";
		
	}
	
	@RequestMapping("/calculate")
	public String claculate(@RequestParam("id") int id) {
		
		studentService.calculateByFg(id);
		
		return "calculate";
		
	}
	
	
	

}