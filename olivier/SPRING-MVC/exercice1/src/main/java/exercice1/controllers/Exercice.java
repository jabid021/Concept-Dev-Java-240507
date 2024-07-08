package exercice1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import exercice1.model.Personne;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/form")
public class Exercice {

	@GetMapping("")
	public String goForm() {
		return "exercice1/form";
	}

	@PostMapping("")
	public String goWelcome(@Valid @ModelAttribute Personne personne, BindingResult br, Model model) {
		boolean error = false;
		
		System.out.println(br);
		
		if (personne.getPrenom() == null || personne.getPrenom().isBlank()) {
			model.addAttribute("prenomError", true);
			error = true;
		}
		if (personne.getNom() == null || personne.getNom().isBlank()) {
			model.addAttribute("nomError", true);
			error = true;
		}

		model.addAttribute("personne", personne);
		if (error) {
			return "exercice1/form";
		} else {
			return "exercice1/welcome";
		}

	}
}
