package soft_eng_demo.sbparent;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/login")
public class LoginController {
	@Autowired
	private LoginService loginService;
	
	@Autowired
	public LoginController(LoginService theLoginService) {
		setLoginService(theLoginService);
	}
	@RequestMapping("/list")
	public String listLogins(Model theModel) {
		
		// get logins from database
		List<Login> theLogins = LoginService.findAll();
		
		// add to the spring model
		theModel.addAttribute("login", theLogins);
		
		return "hello";
	}
	
	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Login theLogin = new Login();
		
		theModel.addAttribute("login", theLogin);
		
		return "login/login-form";
	}

	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("LoginId") String username,
									Model theModel) {
		
		// get the login from the service
		Login theLogin = LoginService.findByString(username);
		
		// set login as a model attribute 
		theModel.addAttribute("login", theLogin);
		
		// send over to our form
		return "login/login-form";			
	}
	
	@RequestMapping("/save")
	public String saveLogin(@ModelAttribute("login") Login theLogin){
				
		// save the login
		LoginService.save(theLogin);
		
		// redirect to /logins/list ACTION
		return "redirect:/login/list";
	}
	
	
	@RequestMapping("/delete")
	public String delete(@RequestParam("LoginId") String username) {
		
		// delete the login
		LoginService.deleteById(username);
		
		// redirect to /login/list 
		return "redirect:/login/list";
		
	}
	public LoginService getLoginService() {
		return loginService;
	}
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

}
