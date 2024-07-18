package fr.formation.api;

import java.util.List;

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

import fr.formation.api.request.PateRequest;
import fr.formation.api.response.PateResponse;
import fr.formation.exception.EntityNotFoundException;
import fr.formation.exception.EntityNotValidException;
import fr.formation.model.Pate;
import fr.formation.repo.PateRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/pate")
public class PateApiController {
	@Autowired
	private PateRepository repoPate;

	@GetMapping
	@PreAuthorize("hasAnyRole('ADMIN','USER')")
	@Operation(summary = "admin et user")
	@SecurityRequirement(name = "Bearer Authentication")
	public List<PateResponse> findAll() {
		return this.repoPate.findAll().stream().map(PateResponse::new).toList();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@PreAuthorize("hasRole('ADMIN')")
	@SecurityRequirement(name = "Bearer Authentication")
	@Operation(summary = "admin")
	public PateResponse add(@Valid @RequestBody PateRequest pateRequest, BindingResult result) {
		if (result.hasErrors()) {
			throw new EntityNotValidException();
		}

		Pate pate = new Pate();

		BeanUtils.copyProperties(pateRequest, pate);

		this.repoPate.save(pate);

		return new PateResponse(pate);
	}

	@PutMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	@Operation(summary = "admin")
	@SecurityRequirement(name = "Bearer Authentication")
	public PateResponse edit(@PathVariable Long id, @Valid @RequestBody PateRequest pateRequest, BindingResult result) {
		if (result.hasErrors()) {
			throw new EntityNotValidException();
		}

		Pate pate = this.repoPate.findById(id).orElseThrow(EntityNotFoundException::new);

		BeanUtils.copyProperties(pateRequest, pate);

		this.repoPate.save(pate);

		return new PateResponse(pate);
	}

	@DeleteMapping("/{id}")
	@Operation(summary = "admin")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PreAuthorize("hasRole('ADMIN')")
	@SecurityRequirement(name = "Bearer Authentication")
	public void deleteById(@PathVariable Long id) {
		try {
			this.repoPate.deleteById(id);
		}

		catch (Exception ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	}
}
