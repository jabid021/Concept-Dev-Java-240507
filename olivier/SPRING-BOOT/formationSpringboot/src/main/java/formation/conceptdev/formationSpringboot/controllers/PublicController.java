package formation.conceptdev.formationSpringboot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/public")
public class PublicController {

	@GetMapping("")
	public String home() {
		return "public/home";
	}
	
	@GetMapping("/page1")
	public String page1() {
		return "public/page1";
	}
}
