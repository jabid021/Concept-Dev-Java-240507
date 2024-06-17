package netfilm.test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import netfilm.context.Singleton;
import netfilm.model.Acteur;
import netfilm.model.Adresse;
import netfilm.model.Categorie;
import netfilm.model.Film;
import netfilm.model.Role;

public class Test {

	public static void main(String[] args) {
		
	
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		
		List<Categorie> categs = new ArrayList();
		categs.add(Categorie.Comedie);
		categs.add(Categorie.Fantastique);
		
		Film f = new Film("Titre",LocalDate.now(),categs);
		
		Adresse a1 = new Adresse("6","Rue rougemont","Paris","75009");
		Acteur acteur1 = new Acteur("Doe","John",a1);
		
		
		Role role1 = new Role("nom","prenom",f,acteur1);
		
	
		
		em.getTransaction().begin();
		
			em.persist(f);
			em.persist(acteur1);
			em.persist(role1);
		
		em.getTransaction().commit();
		
		em.close();
		
		
		
		System.out.println(Singleton.getInstance().getDaoFilm().findAll());
		
		Singleton.getInstance().getEmf().close();
		
	
		
	}

}
