package formationSpringMvcRest.restcontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import formationSpringMvcRest.model.Adresse;
import formationSpringMvcRest.model.Personne;

@RestController
// class DemoRestController va gere des mapping URL
// @RestController permet de definir que tous les retours des methodes de la classe seront changes en JSON (ne concerne pas type simple)
public class DemoRestController {

	@GetMapping("/api/hello")
	public String hello() {
		return "hello world";
	}

	@GetMapping("/api/olivier")
	public Personne getOlivier() {
		return new Personne("olivier", "gozlan", new Adresse("rue wwww", "paris"));
	}

	// regle conversion en json
	// on prend tous les getter si type simple on prend directement la valeur

	@GetMapping("/api/personne/{id}")
	public String exempleUtilisationPAthVariable(@PathVariable Integer id) {
		return "valeur recue:" + id;
	}
	
	@PostMapping("/api/personne")
	public Personne recuperationJSONDuBodyDeLaRequete(@RequestBody Personne personne) {
		return personne;
	}
}
 