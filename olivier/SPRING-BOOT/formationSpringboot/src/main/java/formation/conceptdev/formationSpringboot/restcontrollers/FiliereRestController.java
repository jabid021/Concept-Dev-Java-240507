package formation.conceptdev.formationSpringboot.restcontrollers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import formation.conceptdev.formationSpringboot.dto.request.FiliereRequest;
import formation.conceptdev.formationSpringboot.dto.response.CustomJsonViews;
import formation.conceptdev.formationSpringboot.dto.response.FiliereResponse;
import formation.conceptdev.formationSpringboot.entities.Filiere;
import formation.conceptdev.formationSpringboot.services.FiliereService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/filiere")
@SecurityRequirement(name="basicAuth")
@CrossOrigin(origins = "*")
public class FiliereRestController {

	@Autowired
	private FiliereService filiereSrv;

	@GetMapping("")
	@JsonView(CustomJsonViews.Common.class)
	@Operation(summary = "toute les filieres")
	public List<FiliereResponse> getAll() {
		return filiereSrv.getAll().stream().map(filiere -> new FiliereResponse(filiere, false))
				.collect(Collectors.toList());
	}

	@PostMapping("")
	@ResponseStatus(code = HttpStatus.CREATED)
	@JsonView(CustomJsonViews.Common.class)
	public FiliereResponse create(@Valid @RequestBody FiliereRequest filiereRequest, BindingResult br) {
		if (br.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		Filiere filiere = new Filiere();
		BeanUtils.copyProperties(filiereRequest, filiere);
		return new FiliereResponse(filiereSrv.insert(filiere), false);
	}

	@GetMapping("/{id}")
	@JsonView(CustomJsonViews.Common.class)
	public FiliereResponse getById(@PathVariable Integer id) {
		return new FiliereResponse(filiereSrv.getById(id), false);
	}

	@GetMapping("/{id}/stagiaire")
	@JsonView(CustomJsonViews.FiliereWithStagiaire.class)
	public FiliereResponse getByIdWithStagiaire(@PathVariable Integer id) {
		return new FiliereResponse(filiereSrv.getByIdWithStagiaire(id));
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable("id") Integer id) {
		filiereSrv.deleteById(id);
	}

}
