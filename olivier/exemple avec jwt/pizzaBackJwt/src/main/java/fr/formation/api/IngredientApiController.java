package fr.formation.api;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import fr.formation.api.request.IngredientRequest;
import fr.formation.api.response.IngredientResponse;
import fr.formation.exception.EntityNotFoundException;
import fr.formation.exception.EntityNotValidException;
import fr.formation.model.Ingredient;
import fr.formation.repo.IngredientRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/ingredient")
public class IngredientApiController {
	@Autowired
	private IngredientRepository repoIngredient;

	@GetMapping
	@PreAuthorize("hasAnyRole('USER','ADMIN')")
	@Operation(summary = "admin et user")
	@SecurityRequirement(name = "Bearer Authentication")
	public List<IngredientResponse> findAll() {
		return this.repoIngredient.findAll().stream().map(IngredientResponse::new).toList();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@Operation(summary = "admin",description = "creation d'un ingredient\nname obligatoire\nid generé par la baase de donnée")
	@PreAuthorize("hasRole('ADMIN')")
	@SecurityRequirement(name = "Bearer Authentication")
	public IngredientResponse add(@Valid @RequestBody IngredientRequest ingredientRequest, BindingResult result) {
		if (result.hasErrors()) {
			throw new EntityNotValidException();
		}

		Ingredient ingredient = new Ingredient();

		BeanUtils.copyProperties(ingredientRequest, ingredient);

		this.repoIngredient.save(ingredient);

		return new IngredientResponse(ingredient);
	}

	@PutMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	@Operation(summary = "admin")
	@SecurityRequirement(name = "Bearer Authentication")
	public IngredientResponse edit(@PathVariable Long id, @Valid @RequestBody IngredientRequest ingredientRequest,
			BindingResult result) {
		if (result.hasErrors()) {
			throw new EntityNotValidException();
		}

		Ingredient ingredient = this.repoIngredient.findById(id).orElseThrow(EntityNotFoundException::new);

		BeanUtils.copyProperties(ingredientRequest, ingredient);

		this.repoIngredient.save(ingredient);

		return new IngredientResponse(ingredient);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@Operation(summary = "admin")
	@PreAuthorize("hasRole('ADMIN')")
	@SecurityRequirement(name = "Bearer Authentication")
	public void deleteById(@PathVariable Long id) {
		try {
			this.repoIngredient.deleteById(id);
		}catch (Exception ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	}
}
