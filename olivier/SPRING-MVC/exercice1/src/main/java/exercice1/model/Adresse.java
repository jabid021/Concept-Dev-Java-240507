package exercice1.model;

import jakarta.validation.constraints.NotBlank;

public class Adresse {
	@NotBlank
	private String rue;

	public Adresse() {

	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

}
