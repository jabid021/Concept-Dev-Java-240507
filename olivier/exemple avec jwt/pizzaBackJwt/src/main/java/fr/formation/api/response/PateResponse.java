package fr.formation.api.response;

import org.springframework.beans.BeanUtils;

import fr.formation.model.Pate;

public class PateResponse {
	private Long id;
	private String name;

	
	public PateResponse(Pate pate) {
		BeanUtils.copyProperties(pate, this);
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
