package eshop.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import eshop.model.Produit;
@Repository
@Transactional
public class DAOProduit implements IDAOProduit{

	@PersistenceContext
	EntityManager em;
	@Override
	public Produit findById(Integer id) {
		Produit produit = em.find(Produit.class,	id);
		return produit;
	}

	@Override
	public List<Produit> findAll() {
		List<Produit> produits = em.createQuery("from Produit").getResultList();
		return produits;
	}

	@Override
	public Produit save(Produit produit) {
		produit = em.merge(produit);
		return produit;
	}

	@Override
	public void delete(Integer id) {
		Produit produit = em.find(Produit.class,id);
		em.remove(produit);	
	}

}
