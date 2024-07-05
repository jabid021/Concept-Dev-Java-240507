package formationSpringMvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DemoController {

	//retour =>String (ou ModelAndView)
	// le String correspond au nom de la jsp à afficher 
	
	//@RequestMapping(path = "/hello",method = RequestMethod.GET)
	//@RequestMapping("/hello") //par defaut =>GET
	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}
	
	@GetMapping("")
	public String home() {
		return "redirect:/hello";
	}
	
	
}
