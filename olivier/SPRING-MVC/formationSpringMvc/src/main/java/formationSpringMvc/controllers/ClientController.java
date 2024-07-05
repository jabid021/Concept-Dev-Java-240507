package formationSpringMvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@RequestMapping("/client")
@Controller
public class ClientController {

	@GetMapping("/list")
	public String list(Model model, HttpSession session) {
		model.addAttribute("user", "olivier gozlan");
		session.setAttribute("sessionId", session.getId());
		return "client/list";
	}

	@GetMapping("/add")
	public String add() {
		return "client/add";
	}

}
