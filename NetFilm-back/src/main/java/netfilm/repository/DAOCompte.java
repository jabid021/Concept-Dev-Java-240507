package netfilm.repository;

import java.util.List;

import javax.persistence.EntityManager;

import netfilm.context.Singleton;
import netfilm.model.Compte;

public class DAOCompte implements IDAOCompte {

	@Override
	public List<Compte> findAll() {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		List<Compte> comptes = em.createQuery("FROM Compte").getResultList();
		em.close();
		return comptes;
	}

	@Override
	public Compte findById(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Compte compte = em.find(Compte.class, id);
		em.close();
		return compte;
	}

	@Override
	public Compte save(Compte compte) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		compte =em.merge(compte);
		em.getTransaction().commit();
		em.close();
		return compte;
	}

	@Override
	public void delete(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Compte compte = em.find(Compte.class, id);
		em.getTransaction().begin();
		em.remove(compte);
		em.getTransaction().commit();
		em.close();
	}

}
