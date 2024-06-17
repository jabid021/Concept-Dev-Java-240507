package netfilm.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
@Entity
public class Film {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String titre;
	
	private LocalDate sortie;
	
	@ElementCollection(targetClass = Categorie.class)
	@Enumerated(EnumType.STRING)
	@JoinTable(name = "genres", joinColumns = @JoinColumn(name = "film"))
	@Column(name="categorie",nullable = false)
	private List<Categorie> categories;
	
	@OneToMany(mappedBy = "film")
	private List<Role> personnages;
	
	public Film() {}
	
	public Film(Integer id, String titre, LocalDate sortie, List<Categorie> categories) {
		this.id = id;
		this.titre = titre;
		this.sortie = sortie;
		this.categories = categories;
	}
	
	public Film(String titre, LocalDate sortie, List<Categorie> categories) {
		this.titre = titre;
		this.sortie = sortie;
		this.categories = categories;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public LocalDate getSortie() {
		return sortie;
	}

	public void setSortie(LocalDate sortie) {
		this.sortie = sortie;
	}

	public List<Categorie> getCategories() {
		return categories;
	}

	public void setCategories(List<Categorie> categories) {
		this.categories = categories;
	}

	public List<Role> getPersonnages() {
		return personnages;
	}

	public void setPersonnages(List<Role> personnages) {
		this.personnages = personnages;
	}
	
	
	
	
}
