package quest.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import quest.model.Matiere;

@Repository
@Transactional 
public class DAOMatiere implements IDAOMatiere{

	@PersistenceContext
	private EntityManager em;

	@Override
	public Matiere findById(Integer id) {
		Matiere matiere = em.find(Matiere.class,id);
		return matiere;
	}

	@Override
	public List<Matiere> findAll() {
		List<Matiere> matieres = em.createQuery("from Matiere").getResultList();
		return matieres;
	}

	@Override
	public Matiere save(Matiere matiere) {
		matiere = em.merge(matiere);
		return matiere;
	}

	@Override
	public void delete(Integer id) {
		Matiere matiere = em.find(Matiere.class,id);
		em.remove(matiere);
	}

	@Override
	public Matiere findByQuest(int quest) {
		Matiere matiere=null;
		try {
			/*Query query = em.createQuery("SELECT m from Matiere m where m.quest=:code");
			query.setParameter("code", quest);
			matiere = (Matiere) query.getSingleResult();*/
			matiere = (Matiere) em.createQuery("SELECT m from Matiere m where m.quest=:code").setParameter("code", quest).getSingleResult();	
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		return matiere;
	}


}
