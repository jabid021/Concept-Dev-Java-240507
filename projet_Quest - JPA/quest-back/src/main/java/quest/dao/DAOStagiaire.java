package quest.dao;

import java.util.List;

import javax.persistence.EntityManager;

import quest.context.Singleton;
import quest.model.Stagiaire;

public class DAOStagiaire implements IDAOStagiaire{


	@Override
	public Stagiaire findById(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Stagiaire stagiaire = em.find(Stagiaire.class,id);
		em.close();
		return stagiaire;
	}

	@Override
	public List<Stagiaire> findAll() {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		
		List<Stagiaire> stagiaires = em.createQuery("from Stagiaire").getResultList();
		em.close();
		return stagiaires;
	}

	@Override
	public Stagiaire save(Stagiaire stagiaire) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		stagiaire = em.merge(stagiaire);
		em.getTransaction().commit();
		em.close();
		return stagiaire;
	}

	@Override
	public void delete(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Stagiaire stagiaire = em.find(Stagiaire.class,id);
		em.getTransaction().begin();
		em.remove(stagiaire);
		em.getTransaction().commit();
		em.close();	
	}

	@Override
	public List<Stagiaire> findAllWithoutOrdinateur() {
EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		
		List<Stagiaire> stagiaires = em.createQuery("from Stagiaire as stagiaire where stagiaire.ordinateur is empty").getResultList();
		em.close();
		return stagiaires;
	}
	
}
