package quest.context;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import quest.dao.DAOFiliere;
import quest.dao.DAOMatiere;
import quest.dao.DAOOrdinateur;
import quest.dao.DAOStagiaire;
import quest.dao.IDAOFiliere;
import quest.dao.IDAOMatiere;
import quest.dao.IDAOOrdinateur;
import quest.dao.IDAOStagiaire;

public class Singleton {

	
	private IDAOMatiere daoMatiere = new DAOMatiere();
	private IDAOStagiaire daoStagiaire = new DAOStagiaire();
	private IDAOFiliere daoFiliere = new DAOFiliere();
	private IDAOOrdinateur daoOrdinateur = new DAOOrdinateur();
	private EntityManagerFactory emf= Persistence.createEntityManagerFactory("quest");
	
	private static Singleton instance=null;
	
	private Singleton() {}

	

	public static Singleton getInstance() {
		if(instance==null)
		{
			instance = new Singleton();
		}
		return instance;
	}



	public IDAOMatiere getDaoMatiere() {
		return daoMatiere;
	}



	public void setDaoMatiere(IDAOMatiere daoMatiere) {
		this.daoMatiere = daoMatiere;
	}



	public IDAOStagiaire getDaoStagiaire() {
		return daoStagiaire;
	}



	public void setDaoStagiaire(IDAOStagiaire daoStagiaire) {
		this.daoStagiaire = daoStagiaire;
	}



	public IDAOFiliere getDaoFiliere() {
		return daoFiliere;
	}



	public void setDaoFiliere(IDAOFiliere daoFiliere) {
		this.daoFiliere = daoFiliere;
	}



	public IDAOOrdinateur getDaoOrdinateur() {
		return daoOrdinateur;
	}



	public void setDaoOrdinateur(IDAOOrdinateur daoOrdinateur) {
		this.daoOrdinateur = daoOrdinateur;
	}



	public EntityManagerFactory getEmf() {
		return emf;
	}



	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}


	
	
	
	
}
