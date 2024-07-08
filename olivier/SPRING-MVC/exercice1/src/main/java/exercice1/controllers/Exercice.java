package exercice1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
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
import quest.service.StagiaireService;

@Controller
@RequestMapping("/form")
public class Exercice {
	
	@Autowired
	private StagiaireService stagiaireSrv;

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
		System.out.println(stagiaireSrv);
		return "exercice1/welcome";
	}
}
