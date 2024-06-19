package netfilm.repository;

import java.util.List;

import javax.persistence.EntityManager;

import netfilm.context.Singleton;
import netfilm.model.Film;

public class DAOFilm implements IDAOFilm {

	@Override
	public List<Film> findAll() {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		List<Film> films = em.createQuery("FROM Film").getResultList();
		em.close();
		return films;
	}

	@Override
	public Film findById(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Film film = em.find(Film.class, id);
		em.close();
		return film;
	}

	@Override
	public Film save(Film film) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		film =em.merge(film);
		em.getTransaction().commit();
		em.close();
		return film;
	}

	@Override
	public void delete(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Film film = em.find(Film.class, id);
		em.getTransaction().begin();
		em.remove(film);
		em.getTransaction().commit();
		em.close();
	}
}
