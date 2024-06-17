package netfilm.repository;

import java.util.List;

import javax.persistence.EntityManager;

import netfilm.context.Singleton;
import netfilm.model.Facture;

public class DAOFacture implements IDAOFacture {

	@Override
	public List<Facture> findAll() {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		List<Facture> factures = em.createQuery("FROM Facture").getResultList();
		em.close();
		return factures;
	}

	@Override
	public Facture findById(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Facture facture = em.find(Facture.class, id);
		em.close();
		return facture;
	}

	@Override
	public Facture save(Facture facture) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		facture =em.merge(facture);
		em.getTransaction().commit();
		em.close();
		return facture;
	}

	@Override
	public void delete(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Facture facture = em.find(Facture.class, id);
		em.getTransaction().begin();
		em.remove(facture);
		em.getTransaction().commit();
		em.close();
	}

}
