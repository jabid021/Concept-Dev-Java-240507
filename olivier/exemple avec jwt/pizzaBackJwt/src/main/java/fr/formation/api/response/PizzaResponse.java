package fr.formation.api.response;

import java.util.List;

import org.springframework.beans.BeanUtils;

import fr.formation.model.Pizza;

public class PizzaResponse {
	private Long id;
	private String name;
	private PateResponse pate;
	private List<IngredientResponse> ingredients;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PateResponse getPate() {
		return pate;
	}

	public void setPate(PateResponse pate) {
		this.pate = pate;
	}

	public List<IngredientResponse> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<IngredientResponse> ingredients) {
		this.ingredients = ingredients;
	}

	public PizzaResponse(Pizza pizza) {
		BeanUtils.copyProperties(pizza, this, "pate", "ingredients");
		this.setPate(new PateResponse(pizza.getPate()));
		this.setIngredients(pizza.getIngredients().stream().map(IngredientResponse::new).toList());

	}
}
