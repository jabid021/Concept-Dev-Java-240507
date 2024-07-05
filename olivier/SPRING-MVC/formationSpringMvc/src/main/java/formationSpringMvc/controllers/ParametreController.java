package formationSpringMvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/param")
public class ParametreController {

	@GetMapping("")
	public String hello(@RequestParam(name="prenom",required = false,defaultValue = "world") String prenom ,Model model) {
		model.addAttribute("prenom", prenom);
		return "param/param";
	}
}
