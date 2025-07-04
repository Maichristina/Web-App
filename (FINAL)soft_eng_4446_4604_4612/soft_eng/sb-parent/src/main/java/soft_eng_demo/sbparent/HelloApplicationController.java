package soft_eng_demo.sbparent;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
public class HelloApplicationController {

		// create a mapping for "/hello"
		
		// Here we specify the method that should be called by spring
		// when the client issues a http://uuuu.xxxx.yyyy.zzzz:pppp/hello request
		@RequestMapping("/hello")
		public String sayHello(Model theModel) {
			
			// Here we add data to theModel that will be used by spring to 
			// generate the result html page for the client  
			theModel.addAttribute("helloDate", new java.util.Date());
			
			// Here we say to spring that this is the name of 
			// the html page template that should be used to generate
			// the result page for the client based on the data put in theModel object  
			return "hello";
		}
}
