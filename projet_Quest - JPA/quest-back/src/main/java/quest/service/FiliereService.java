package quest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import quest.dao.IDAOFiliere;
import quest.model.Filiere;

@Service
public class FiliereService {
	
	@Autowired
	IDAOFiliere daoFiliere;
	
	public Filiere getById(Integer id) 
	{
		if(id==null) 
		{
			throw new RuntimeException("Impossible de find une filiere sans id ???");
		}
		Optional<Filiere> opt = daoFiliere.findById(id);
		if(opt.isPresent()) 
		{
			return opt.get();
		}
		return null;
	}
	
	public List<Filiere> getAll() 
	{
		return daoFiliere.findAll();
	}
	
	public Filiere insert(Filiere filiere) 
	{
		return daoFiliere.save(filiere);
	}
	
	public Filiere update(Filiere filiere) 
	{
		if(filiere.getId()==null) 
		{
			throw new RuntimeException("Impossible d'update une filiere sans id ???");
		}
		return daoFiliere.save(filiere);
	}
	
	public void deleteById(Integer id) 
	{
		if(id==null) 
		{
			throw new RuntimeException("Impossible de supprimer une filiere sans id ???");
		}
		daoFiliere.deleteById(id);
	}
	
	public void delete(Filiere filiere) 
	{
		if(filiere.getId()==null) 
		{
			throw new RuntimeException("Impossible de supprimer une filiere sans id ???");
		}
		deleteById(filiere.getId());
	}
}
