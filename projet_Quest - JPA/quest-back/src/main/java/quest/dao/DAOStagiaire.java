package quest.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import quest.context.Singleton;
import quest.model.Stagiaire;

@Repository
@Transactional 
public class DAOStagiaire implements IDAOStagiaire{

	 @PersistenceContext
	 private EntityManager em;
	 
	@Override
	public Stagiaire findById(Integer id) {
		Stagiaire stagiaire = em.find(Stagiaire.class,id);
		return stagiaire;
	}

	@Override
	public List<Stagiaire> findAll() {
		List<Stagiaire> stagiaires = em.createQuery("from Stagiaire").getResultList();
		return stagiaires;
	}

	@Override
	public Stagiaire save(Stagiaire stagiaire) {
		stagiaire = em.merge(stagiaire);
		return stagiaire;
	}

	@Override
	public void delete(Integer id) {
		Stagiaire stagiaire = em.find(Stagiaire.class,id);
		em.remove(stagiaire);
	}
	
	@Override
	public List<Stagiaire> findAllDisponibles() {
		List<Stagiaire> stagiaires = em.createQuery("SELECT s from Stagiaire s where s.ordinateur is empty").getResultList();
		return stagiaires;
	}

}
