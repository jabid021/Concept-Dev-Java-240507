package quest.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name="filiere")
public class Filiere {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String libelle;
	private LocalDate debut;
	private LocalDate fin;
	
	@Version
	private int version;
	
	public Filiere() {}
	
	public Filiere(Integer id, String libelle, LocalDate debut, LocalDate fin) {
		this.id = id;
		this.libelle = libelle;
		this.debut = debut;
		this.fin = fin;
	}
	
	public Filiere(String libelle, LocalDate debut, LocalDate fin) {
		this.libelle = libelle;
		this.debut = debut;
		this.fin = fin;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public LocalDate getDebut() {
		return debut;
	}

	public void setDebut(LocalDate debut) {
		this.debut = debut;
	}

	public LocalDate getFin() {
		return fin;
	}

	public void setFin(LocalDate fin) {
		this.fin = fin;
	}

	
	
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "Filiere [id=" + id + ", libelle=" + libelle + ", debut=" + debut + ", fin=" + fin + "]";
	}
	
	
	
	
}
