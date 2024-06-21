package eshop.dao;

import java.util.List;

import javax.persistence.EntityManager;

import eshop.context.Singleton;
import eshop.model.Produit;

public class DAOProduit implements IDAOProduit{


	@Override
	public Produit findById(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Produit produit = em.find(Produit.class,	id);
		em.close();
		return produit;
	}

	@Override
	public List<Produit> findAll() {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		
		List<Produit> produits = em.createQuery("from Produit").getResultList();
		em.close();
		return produits;
	}

	@Override
	public Produit save(Produit produit) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		produit = em.merge(produit);
		em.getTransaction().commit();
		em.close();
		return produit;
	}

	@Override
	public void delete(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Produit produit = em.find(Produit.class,id);
		em.getTransaction().begin();
		em.remove(produit);
		em.getTransaction().commit();
		em.close();	
	}

}
