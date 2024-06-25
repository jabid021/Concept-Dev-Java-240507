package quest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import quest.dao.IDAOMatiere;
import quest.model.Matiere;

@Service
public class MatiereService {
	
	@Autowired
	IDAOMatiere daoMatiere;
	
	public Matiere getById(Integer id) 
	{
		if(id==null) 
		{
			throw new RuntimeException("Impossible de find une matiere sans id ???");
		}
		Matiere matiere = daoMatiere.findById(id);
		return matiere;
	}
	
	public List<Matiere> getAll() 
	{
		return daoMatiere.findAll();
	}
	
	public Matiere insert(Matiere matiere) 
	{
		if(matiere.getLibelle()==null) 
		{
			throw new RuntimeException("Impossible d'insert une matiere sans libelle");
		}
		if(matiere.getLibelle().length()>=50) 
		{
			throw new RuntimeException("Impossible d'insert une matiere dont le libelle fait plus de 50 caracteres");
		}
		return daoMatiere.save(matiere);
	}
	
	public Matiere update(Matiere matiere) 
	{
		if(matiere.getId()==null) 
		{
			throw new RuntimeException("Impossible d'update une matiere sans id ???");
		}
		if(matiere.getLibelle()==null) 
		{
			throw new RuntimeException("Impossible d'insert une matiere sans libelle");
		}
		if(matiere.getLibelle().length()>=50) 
		{
			throw new RuntimeException("Impossible d'insert une matiere dont le libelle fait plus de 50 caracteres");
		}
		return daoMatiere.save(matiere);
	}
	
	public void deleteById(Integer id) 
	{
		if(id==null) 
		{
			throw new RuntimeException("Impossible de supprimer une matiere sans id ???");
		}
		daoMatiere.delete(id);
	}
	
	public void delete(Matiere matiere) 
	{
		if(matiere.getId()==null) 
		{
			throw new RuntimeException("Impossible de supprimer une matiere sans id ???");
		}
		deleteById(matiere.getId());
	}

	
	public Matiere getByQuest(int quest) 
	{
		return daoMatiere.findByQuest(quest);
	}
}
