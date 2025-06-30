package soft_eng_demo.sbparent;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/courses")
public class CoursesController {
	@Autowired
	private CoursesService coursesService;
	
	@Autowired
	public CoursesController(CoursesService theCoursesService) {
		coursesService = theCoursesService;
	}
	
	@RequestMapping("/list")
	public String listCourses(Model theModel) {
		
		// get courses from database
		List<Courses> theCourses = coursesService.findAll();
		
		// add to the spring model
		theModel.addAttribute("courses", theCourses);
		
		return "courses";
	}
	
	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		Courses theCourses= new Courses();
		
		theModel.addAttribute("courses", theCourses);
		
		return "courses-form";
	}

	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("id") int id,
									Model theModel) {
		
		// get the course from the service
		Courses theCourses = CoursesService.findById(id);
		
		
		// set course as a model attribute to pre-populate the form
		theModel.addAttribute("courses", theCourses);
		
		
		// send over to our form
		return  "courses-form";			
	}
	
	
	@RequestMapping("/save")
	public String saveCourses(@ModelAttribute("courses") Courses theCourses, Model theModel) {
		
		// save the course
		coursesService.save(theCourses);
		
		// use a redirect to prevent duplicate submissions
		return "redirect:/courses/list";
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam("id") int id) {
		
		// delete the course
		coursesService.deleteById(id);
		
		// redirect to /courses/list
		return "redirect:/courses/list";
		
	}
}