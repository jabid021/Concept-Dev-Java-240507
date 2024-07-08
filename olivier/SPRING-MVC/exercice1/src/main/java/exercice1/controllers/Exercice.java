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
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/form")
public class Exercice {

	@GetMapping("")
	public String goForm(Model model) {
		model.addAttribute("personne", new Personne());
		return "exercice1/form";
	}

	@PostMapping("")
	public String goWelcome(@Valid @ModelAttribute Personne personne, BindingResult br, Model model,
			HttpSession session) {
		if (br.hasErrors()) {
			return "exercice1/form";
		}
		session.setAttribute("personne", personne);
		return "redirect:/form/welcome";
	}

	@GetMapping("/welcome")
	public String welcome() {
		return "exercice1/welcome";
	}
}
