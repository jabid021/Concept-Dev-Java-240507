package quest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import quest.dao.IDAOStagiaire;
import quest.model.Stagiaire;

@Service
public class StagiaireService {

	@Autowired
	IDAOStagiaire daoStagiaire;

	public Stagiaire getById(Integer id) 
	{
		if(id==null) 
		{
			throw new RuntimeException("Impossible de find un stagiaire sans id ???");
		}
		Optional<Stagiaire> opt = daoStagiaire.findById(id);
		if(opt.isPresent()) 
		{
			return opt.get();
		}
		return null;
	}

	public List<Stagiaire> getAll() 
	{
		return daoStagiaire.findAll();
	}
	
	public List<Stagiaire> getAllDisponibles() 
	{
		return daoStagiaire.findAllDisponibles();
	}


	public Stagiaire insert(Stagiaire stagiaire) 
	{
		if(stagiaire.getFiliere()==null) 
		{
			throw new RuntimeException("Impossible d'insert un stagiaire sans une filiere");
		}
		if(stagiaire.getFiliere().getId()==null) 
		{
			throw new RuntimeException("Impossible d'insert un stagiaire avec une filiere sans id");
		}
		return daoStagiaire.save(stagiaire);
	}

	public Stagiaire update(Stagiaire stagiaire) 
	{
		if(stagiaire.getId()==null) 
		{
			throw new RuntimeException("Impossible d'update une stagiaire sans id");
		}
		if(stagiaire.getFiliere()==null) 
		{
			throw new RuntimeException("Impossible d'update un stagiaire sans une filiere");
		}
		if(stagiaire.getFiliere().getId()==null) 
		{
			throw new RuntimeException("Impossible d'update un stagiaire avec une filiere sans id");
		}
		return daoStagiaire.save(stagiaire);
	}

	public void deleteById(Integer id) 
	{
		if(id==null) 
		{
			throw new RuntimeException("Impossible de supprimer une stagiaire sans id ???");
		}
		daoStagiaire.deleteById(id);
	}

	public void delete(Stagiaire stagiaire) 
	{
		if(stagiaire.getId()==null) 
		{
			throw new RuntimeException("Impossible de supprimer une stagiaire sans id ???");
		}
		deleteById(stagiaire.getId());
	}
}
