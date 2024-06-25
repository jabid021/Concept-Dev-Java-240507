package eshop.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import eshop.model.Achat;

@Repository
@Transactional
public class DAOAchat implements IDAOAchat{

	@PersistenceContext
	EntityManager em;

	@Override
	public Achat findById(Integer id) {
		Achat achat = em.find(Achat.class,	id);
		return achat;
	}

	@Override
	public List<Achat> findAll() {
		List<Achat> achats = em.createQuery("from Achat").getResultList();
		return achats;
	}

	@Override
	public Achat save(Achat achat) {
		achat = em.merge(achat);
		return achat;
	}

	@Override
	public void delete(Integer id) {
		Achat achat = em.find(Achat.class,id);
		em.remove(achat);
	}

}
