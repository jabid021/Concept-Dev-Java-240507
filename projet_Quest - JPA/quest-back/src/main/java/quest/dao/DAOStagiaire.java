package quest.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

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
	
	
	
	public List<Stagiaire> findStagiaireBesoinOrdi(Integer id_ordi) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		
		TypedQuery<Stagiaire> tq = null;
		if (id_ordi==null)
		{
			tq = em.createQuery("select stagiaire \r\n"
					+ " from Stagiaire stagiaire left join Ordinateur ordinateur \r\n"
					+ " on   stagiaire.id = ordinateur.stagiaire\r\n"
					+ " where ordinateur.id is null",Stagiaire.class);
		}
		else
		{
			tq = em.createQuery("select stagiaire \r\n"
					+ " from Stagiaire stagiaire left join Ordinateur ordinateur \r\n"
					+ " on   stagiaire.id = ordinateur.stagiaire\r\n"
					+ " where ordinateur.id=:id_ordi  or ordinateur.id is null",Stagiaire.class);
			
			tq.setParameter("id_ordi", id_ordi);		
			
			
		}		
		
		
	
		List<Stagiaire> stagiaires =tq.getResultList();
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

}
