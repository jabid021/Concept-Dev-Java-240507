package netfilm.repository;

import java.util.List;

import javax.persistence.EntityManager;

import netfilm.context.Singleton;
import netfilm.model.Role;

public class DAORole implements IDAORole {

	@Override
	public List<Role> findAll() {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		List<Role> roles = em.createQuery("FROM Role").getResultList();
		em.close();
		return roles;
	}

	@Override
	public Role findById(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Role role = em.find(Role.class, id);
		em.close();
		return role;
	}

	@Override
	public Role save(Role role) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		role =em.merge(role);
		em.getTransaction().commit();
		em.close();
		return role;
	}

	@Override
	public void delete(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Role role = em.find(Role.class, id);
		em.getTransaction().begin();
		em.remove(role);
		em.getTransaction().commit();
		em.close();
	}

}
