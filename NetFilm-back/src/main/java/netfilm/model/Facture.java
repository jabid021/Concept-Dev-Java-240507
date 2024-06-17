package netfilm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity // Obligatoire
@Table(name="facture") //Sur mac, la table aura le nom de la classe par defaut (Facture)
public class Facture {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name="price",columnDefinition = "DECIMAL(4,2)")
	private double prix;
	private boolean valide;
	
	@OneToOne
	@JoinColumn(name="acheteur",nullable = false)
	private Client client;
	
	public Facture() {} 
	
	public Facture(Integer id, double prix, boolean valide) {
		this.id = id;
		this.prix = prix;
		this.valide = valide;
	}
	
	public Facture(double prix, boolean valide) {
		this.prix = prix;
		this.valide = valide;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public boolean isValide() {
		return valide;
	}

	public void setValide(boolean valide) {
		this.valide = valide;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	

}
