package netfilm.context;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import netfilm.repository.DAOActeur;
import netfilm.repository.DAOCompte;
import netfilm.repository.DAOFacture;
import netfilm.repository.DAOFilm;
import netfilm.repository.DAORole;
import netfilm.repository.IDAOActeur;
import netfilm.repository.IDAOCompte;
import netfilm.repository.IDAOFacture;
import netfilm.repository.IDAOFilm;
import netfilm.repository.IDAORole;

public class Singleton {

	
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("contextJPA");

	private IDAORole daoRole = new DAORole();
	private IDAOActeur daoActeur = new DAOActeur();
	private IDAOFacture daoFacture = new DAOFacture();
	private IDAOCompte daoCompte = new DAOCompte();
	private IDAOFilm daoFilm = new DAOFilm();
	
	private static Singleton instance=null;
	
	private Singleton() {}
	
	public static Singleton getInstance() 
	{
		if(instance==null) 
		{
			instance=new Singleton();
		}
		
		return instance;
		
	}
	
	
	
	public IDAORole getDaoRole() {
		return daoRole;
	}

	public IDAOActeur getDaoActeur() {
		return daoActeur;
	}

	public IDAOFacture getDaoFacture() {
		return daoFacture;
	}

	public IDAOCompte getDaoCompte() {
		return daoCompte;
	}

	public IDAOFilm getDaoFilm() {
		return daoFilm;
	}

	public EntityManagerFactory getEmf() {
		return emf;
	}

	
	
	
	
	
	
	
	
	
}
