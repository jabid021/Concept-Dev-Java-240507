package fr.formation.api.response;

import org.springframework.beans.BeanUtils;

import fr.formation.model.Ingredient;

public class IngredientResponse {
	private Long id;
	private String name;
	
	public IngredientResponse() {
		
	}
	
	public IngredientResponse(Ingredient ingredient) {
		BeanUtils.copyProperties(ingredient, this);
	}

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
	
}
