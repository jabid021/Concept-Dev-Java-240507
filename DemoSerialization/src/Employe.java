import java.io.Serializable;

public class Employe implements Serializable {

	private String nom;
	private String prenom;
	private transient int age;
	
	public Employe(String nom, String prenom, int age) {
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Employe [nom=" + nom + ", prenom=" + prenom + ", age=" + age + "]";
	}
	
	
	
	
}
