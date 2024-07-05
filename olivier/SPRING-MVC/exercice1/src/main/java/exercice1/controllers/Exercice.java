package exercice1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/form")
public class Exercice {

	@GetMapping("")
	public String goForm() {
		return "exercice1/form";
	}

	@PostMapping("")
	public String goWelcome(@RequestParam(name = "prenom", required = false) String prenom,
			@RequestParam(name = "nom", required = false) String nom, Model model) {
		boolean error = false;
		if (prenom == null || prenom.isBlank()) {
			model.addAttribute("prenomError", true);
			error = true;
		}
		if (nom == null || nom.isBlank()) {
			model.addAttribute("nomError", true);
			error = true;
		}
		model.addAttribute("prenom", prenom);
		model.addAttribute("nom", nom);
		if (error) {
			return "exercice1/form";
		} else {
			return "exercice1/welcome";
		}
	}
}
