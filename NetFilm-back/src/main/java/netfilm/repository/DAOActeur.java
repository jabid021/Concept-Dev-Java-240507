package netfilm.repository;

import java.util.List;

import javax.persistence.EntityManager;

import netfilm.context.Singleton;
import netfilm.model.Acteur;

public class DAOActeur implements IDAOActeur {

	@Override
	public List<Acteur> findAll() {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		List<Acteur> acteurs = em.createQuery("FROM Acteur").getResultList();
		em.close();
		return acteurs;
	}

	@Override
	public Acteur findById(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Acteur acteur = em.find(Acteur.class, id);
		em.close();
		return acteur;
	}

	@Override
	public Acteur save(Acteur acteur) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		acteur =em.merge(acteur);
		em.getTransaction().commit();
		em.close();
		return acteur;
	}

	@Override
	public void delete(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Acteur acteur = em.find(Acteur.class, id);
		em.getTransaction().begin();
		em.remove(acteur);
		em.getTransaction().commit();
		em.close();
	}

}
