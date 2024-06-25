package quest.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import quest.model.Ordinateur;

@Repository
@Transactional 
public class DAOOrdinateur implements IDAOOrdinateur{

	 @PersistenceContext
	 private EntityManager em;

	@Override
	public Ordinateur findById(Integer id) {
		Ordinateur ordinateur = em.find(Ordinateur.class,id);
		return ordinateur;
	}

	@Override
	public List<Ordinateur> findAll() {
		List<Ordinateur> ordinateurs = em.createQuery("from Ordinateur").getResultList();
		return ordinateurs;
	}

	@Override
	public Ordinateur save(Ordinateur ordinateur) {
		ordinateur = em.merge(ordinateur);
		return ordinateur;
	}

	@Override
	public void delete(Integer id) {
		Ordinateur ordinateur = em.find(Ordinateur.class,id);
		em.remove(ordinateur);
	}

}
