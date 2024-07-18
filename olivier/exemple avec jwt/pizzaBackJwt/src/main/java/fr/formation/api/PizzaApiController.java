package fr.formation.api;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import fr.formation.api.request.PizzaRequest;
import fr.formation.api.response.PizzaResponse;
import fr.formation.exception.EntityNotFoundException;
import fr.formation.exception.EntityNotValidException;
import fr.formation.model.Ingredient;
import fr.formation.model.Pate;
import fr.formation.model.Pizza;
import fr.formation.repo.PizzaRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/pizza")
public class PizzaApiController {
	@Autowired
	private PizzaRepository pizzaRepo;

	@GetMapping
	@PreAuthorize("hasAnyRole('USER','ADMIN')")
	@Operation(summary = "admin et user")
	@SecurityRequirement(name = "Bearer Authentication")
	public List<PizzaResponse> findAll() {
		return this.pizzaRepo.findAll().stream().map(PizzaResponse::new).toList();
	}

	@GetMapping("/{id}")
	@PreAuthorize("hasAnyRole('USER','ADMIN')")
	@Operation(summary = "admin et user")
	@SecurityRequirement(name = "Bearer Authentication")
	public PizzaResponse findById(@PathVariable("id") Long id) {
		Pizza pizza = this.pizzaRepo.findById(id).orElseThrow(EntityNotFoundException::new);
		return new PizzaResponse(pizza);
	}

	@GetMapping("/name/{name}")
	@PreAuthorize("hasAnyRole('USER','ADMIN')")
	@Operation(summary = "admin et user")
	@SecurityRequirement(name = "Bearer Authentication")
	public List<PizzaResponse> findByName(@PathVariable("name") String name) {
		return this.pizzaRepo.findByNameContaining(name).stream().map(PizzaResponse::new).toList();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@PreAuthorize("hasRole('ADMIN')")
	@Operation(summary = "admin")
	@SecurityRequirement(name = "Bearer Authentication")
	public PizzaResponse add(@Valid @RequestBody PizzaRequest pizzaRequest, BindingResult result) {
		if (result.hasErrors()) {
			throw new EntityNotValidException();
		}

		Pizza pizza = new Pizza();
		Pate pate = new Pate();

		BeanUtils.copyProperties(pizzaRequest, pizza);

		pizza.setPate(pate);
		pate.setId(pizzaRequest.getPateId());
		pizza.setIngredients(pizzaRequest.getIngredientsIds().stream().map(id -> {
			Ingredient ingredient = new Ingredient();
			ingredient.setId(id);
			return ingredient;
		}).collect(Collectors.toSet()));
		pizza=this.pizzaRepo.save(pizza);

		return new PizzaResponse(pizza);
	}

	@PutMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	@Operation(summary = "admin")
	@SecurityRequirement(name = "Bearer Authentication")
	public PizzaResponse edit(@PathVariable Long id, @Valid @RequestBody PizzaRequest pizzaRequest,
			BindingResult result) {
		if (result.hasErrors()) {
			throw new EntityNotValidException();
		}

		Pizza pizza = this.pizzaRepo.findById(id).orElseThrow(EntityNotFoundException::new);
		Pate pate = new Pate();

		BeanUtils.copyProperties(pizzaRequest, pizza);

		pate.setId(pizzaRequest.getPateId());
		pizza.setPate(pate);
		pizza.setIngredients(pizzaRequest.getIngredientsIds().stream().map(idIngredient -> {
			Ingredient ingredient = new Ingredient();
			ingredient.setId(idIngredient);
			return ingredient;
		}).collect(Collectors.toSet()));
		this.pizzaRepo.save(pizza);

		return new PizzaResponse(pizza);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PreAuthorize("hasRole('ADMIN')")
	@Operation(summary = "admin")
	@SecurityRequirement(name = "Bearer Authentication")
	public void deleteById(@PathVariable Long id) {
		try {
			this.pizzaRepo.deleteById(id);
		}catch (Exception ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	}
}
