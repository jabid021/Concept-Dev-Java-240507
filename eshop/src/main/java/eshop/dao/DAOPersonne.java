package eshop.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import eshop.model.Personne;
@Repository
@Transactional
public class DAOPersonne implements IDAOPersonne{

	@PersistenceContext
	EntityManager em;
	
	@Override
	public Personne findById(Integer id) {
		Personne personne = em.find(Personne.class,	id);
		return personne;
	}

	@Override
	public List<Personne> findAll() {
		List<Personne> personnes = em.createQuery("from Personne").getResultList();
		return personnes;
	}

	@Override
	public Personne save(Personne personne) {
		personne = em.merge(personne);
		return personne;
	}

	@Override
	public void delete(Integer id) {
		Personne personne = em.find(Personne.class,id);
		em.remove(personne);
	}

}
