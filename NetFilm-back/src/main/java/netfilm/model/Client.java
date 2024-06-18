package netfilm.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;

@Entity
public class Client extends Compte{

	private String nom;
	private String prenom;
	
	@Enumerated(EnumType.STRING)
	private Civilite civilite;
	
	@Embedded
	private Adresse adresse;
	
	@OneToOne(mappedBy = "client")
	private Facture facture;
	
	public Client() {}
	
	public Client(Integer id, String login, String password,String prenom,String nom,Civilite civilite,Adresse adresse) {
		super(id, login, password);
		this.adresse=adresse;
		this.civilite=civilite;
		this.prenom=prenom;
		this.nom=nom;
	}

	public Client(String login, String password,String prenom,String nom,Civilite civilite,Adresse adresse) {
		super(login, password);
		this.adresse=adresse;
		this.civilite=civilite;
		this.prenom=prenom;
		this.nom=nom;
	}

	public Civilite getCivilite() {
		return civilite;
	}

	public void setCivilite(Civilite civilite) {
		this.civilite = civilite;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public Facture getFacture() {
		return facture;
	}

	public void setFacture(Facture facture) {
		this.facture = facture;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	
	
	
	
	
}
