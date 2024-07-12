package formation.conceptdev.exoBoot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/public")
public class AllController {
	@GetMapping("/hello")
	public String hello() {
		return "public/hello";
	}
}
