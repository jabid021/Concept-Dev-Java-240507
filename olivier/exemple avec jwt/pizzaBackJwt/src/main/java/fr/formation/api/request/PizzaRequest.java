package fr.formation.api.request;

import java.util.List;

public class PizzaRequest {
	private Long id;
	private String name;
	private Long pateId;
	private List<Long> ingredientsIds;

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

	public Long getPateId() {
		return pateId;
	}

	public void setPateId(Long pateId) {
		this.pateId = pateId;
	}

	public List<Long> getIngredientsIds() {
		return ingredientsIds;
	}

	public void setIngredientsIds(List<Long> ingredientsIds) {
		this.ingredientsIds = ingredientsIds;
	}

}
