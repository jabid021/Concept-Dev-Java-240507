package quest.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import quest.model.Filiere;
@Repository
@Transactional 
public class DAOFiliere implements IDAOFiliere{

	 @PersistenceContext
	 private EntityManager em;
	 
	@Override
	public Filiere findById(Integer id) {
		Filiere filiere = em.find(Filiere.class,id);
		return filiere;
	}

	@Override
	public List<Filiere> findAll() {
		List<Filiere> filieres = em.createQuery("from Filiere").getResultList();
		return filieres;
	}

	@Override
	public Filiere save(Filiere filiere) {
		filiere = em.merge(filiere);
		return filiere;
	}

	@Override
	public void delete(Integer id) {
		Filiere filiere = em.find(Filiere.class,id);
		em.remove(filiere);
	}

}
