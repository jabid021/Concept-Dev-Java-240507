package quest.dao;

import java.util.List;

import quest.model.Stagiaire;

public interface IDAOStagiaire extends IDAO<Stagiaire,Integer> {

	public List<Stagiaire> findAllDisponibles();
}
