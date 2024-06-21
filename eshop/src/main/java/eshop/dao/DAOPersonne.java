package eshop.dao;

import java.util.List;

import javax.persistence.EntityManager;

import eshop.context.Singleton;
import eshop.model.Personne;

public class DAOPersonne implements IDAOPersonne{


	@Override
	public Personne findById(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Personne personne = em.find(Personne.class,	id);
		em.close();
		return personne;
	}

	@Override
	public List<Personne> findAll() {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		
		List<Personne> personnes = em.createQuery("from Personne").getResultList();
		em.close();
		return personnes;
	}

	@Override
	public Personne save(Personne personne) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		personne = em.merge(personne);
		em.getTransaction().commit();
		em.close();
		return personne;
	}

	@Override
	public void delete(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Personne personne = em.find(Personne.class,id);
		em.getTransaction().begin();
		em.remove(personne);
		em.getTransaction().commit();
		em.close();	
	}

}
