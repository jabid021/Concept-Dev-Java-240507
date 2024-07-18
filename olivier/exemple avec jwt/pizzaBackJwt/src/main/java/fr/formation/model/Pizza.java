package fr.formation.model;

import java.util.List;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "pizza")
public class Pizza {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pizza_id")
	private Long id;
	@Column(name = "pizza_name", nullable = false)
	private String name;
	@ManyToMany
	@JoinTable(name = "pizza_ingredient", inverseJoinColumns = @JoinColumn(name = "pizza_ingredient_ingredient_id", foreignKey = @ForeignKey(name = "pizza_ingredient_ingredient_id")), joinColumns = @JoinColumn(name = "pizza_ingredient_pizza_id", foreignKey = @ForeignKey(name = "pizza_ingredient_pizza_id_fk")))
	private Set<Ingredient> ingredients;
	@ManyToOne
	@JoinColumn(name = "pizza_pate_id", foreignKey = @ForeignKey(name = "pizza_pate_id_fk"))
	private Pate pate;

	public Pizza() {

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

	public Set<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(Set<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	public Pate getPate() {
		return pate;
	}

	public void setPate(Pate pate) {
		this.pate = pate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pizza other = (Pizza) obj;
		return Objects.equals(id, other.id);
	}

}
