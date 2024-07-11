package formation.conceptdev.formationSpringboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import formation.conceptdev.formationSpringboot.entities.Matiere;
import formation.conceptdev.formationSpringboot.services.MatiereService;

@Controller
@RequestMapping("/matiere")
public class MatiereController {

	@Autowired
	private MatiereService matiereSrv;

	@GetMapping("")
	public String list(Model model) {
		model.addAttribute("matieres", matiereSrv.getAll());
		model.addAttribute("matiere", new Matiere());
		return "matiere/list";
	}

	@GetMapping("/update")
	public String update(@RequestParam Integer id, Model model) {
		model.addAttribute("matiere", matiereSrv.getById(id));
		return "matiere/update";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam Integer id) {
		matiereSrv.deleteById(id);
		return "redirect:/matiere";
	}

	@PostMapping("/save")
	public String save(@ModelAttribute Matiere matiere) {
		if (matiere.getId() == null) {
			matiereSrv.insert(matiere);
		} else {
			matiereSrv.update(matiere);
		}
		return "redirect:/matiere";
	}

	@PostMapping("/update")
	public String saveUpdate(@ModelAttribute Matiere matiere) {
		matiereSrv.update(matiere);
		return "redirect:/matiere";
	}
}
