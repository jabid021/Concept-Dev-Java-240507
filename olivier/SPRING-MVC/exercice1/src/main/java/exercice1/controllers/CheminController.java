package exercice1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CheminController {

	@GetMapping("/page1")
	public String page1() {
		return "page1";
	}
	

	@GetMapping("/rubrique/page2")
	public String page2() {
		return "page2";
	}
}
