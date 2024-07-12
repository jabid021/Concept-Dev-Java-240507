package formation.conceptdev.exoBoot.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import formation.conceptdev.exoBoot.entities.Compte;

@Controller
@RequestMapping("/user")
public class UserController {
	@GetMapping("/hello")
	public String hello(@AuthenticationPrincipal Compte userDetails ) {
		//Compte compte=(Compte)userDetails;
		
		return "user/hello";
	}
}
