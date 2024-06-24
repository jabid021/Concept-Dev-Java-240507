package test;

import org.springframework.beans.factory.annotation.Autowired;

import quest.dao.IDAOFiliere;
import quest.dao.IDAOMatiere;
import quest.dao.IDAOOrdinateur;
import quest.dao.IDAOStagiaire;
import quest.model.Filiere;
import quest.model.Matiere;
import quest.model.Ordinateur;
import quest.model.Stagiaire;

public class App {

	//Pourquoi ne pas mettre IDAO daoMatiere / DAOMatiere daoMatiere ???
	@Autowired
	IDAOMatiere daoMatiere;
	
	@Autowired
	IDAOFiliere daoFiliere;
	
	@Autowired
	IDAOOrdinateur daoOrdinateur;
	
	@Autowired
	IDAOStagiaire daoStagiaire;
	
	public void run() {

		
		
		for(Matiere m : daoMatiere.findAll()) 
		{
			System.out.println(m);
		}
		
		System.out.println("------------");
		for(Stagiaire s : daoStagiaire.findAllDisponibles()) 
		{
			System.out.println(s);
		}
		
		System.out.println("------------");
		for(Ordinateur o : daoOrdinateur.findAll()) 
		{
			System.out.println(o);
		}
		
		
		System.out.println("------------");
		for(Filiere f : daoFiliere.findAll()) 
		{
			System.out.println(f);
		}
		
		
		
	}

}
