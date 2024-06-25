package test;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import quest.dao.IDAOFiliere;
import quest.dao.IDAOOrdinateur;
import quest.dao.IDAOStagiaire;
import quest.model.Filiere;
import quest.model.Matiere;
import quest.model.Ordinateur;
import quest.model.Stagiaire;
import quest.service.MatiereService;

public class App {

	//Pourquoi ne pas mettre IDAO daoMatiere / DAOMatiere daoMatiere ???
	@Autowired
	MatiereService matiereSrv;
	
	@Autowired
	IDAOFiliere daoFiliere;
	
	@Autowired
	IDAOOrdinateur daoOrdinateur;
	
	@Autowired
	IDAOStagiaire daoStagiaire;
	
	public void run() {

		System.out.println("-----BLOC Matiere-------");
		System.out.println("matiere code : 7858"+matiereSrv.getByQuest(7858));
		System.out.println(matiereSrv.getById(1));
		for(Matiere m : matiereSrv.getAll()) 
		{
			System.out.println(m);
		}
		
		
		
		System.out.println("-----BLOC Stagiaire-------");
		System.out.println(daoStagiaire.findById(1));
		for(Stagiaire s : daoStagiaire.findAllDisponibles()) 
		{
			System.out.println(s);
		}
		
		System.out.println("-----BLOC Ordinateur-------");
		System.out.println(daoOrdinateur.findById(1));
		for(Ordinateur o : daoOrdinateur.findAll()) 
		{
			System.out.println(o);
		}
		
		
		System.out.println("-----BLOC Filiere-------");
		
		Optional<Filiere> opt = daoFiliere.findById(1);
		if(opt.isPresent()) 
		{
			System.out.println(opt.get());
		}
		
		/*System.out.println(daoFiliere.findById(1));
		for(Filiere f : daoFiliere.findAll()) 
		{
			System.out.println(f);
		}*/
		
		
		
	}

}
