package test;

import quest.context.Singleton;
import quest.dao.DAOFiliere;
import quest.dao.DAOOrdinateur;
import quest.dao.DAOStagiaire;
import quest.dao.IDAOFiliere;
import quest.dao.IDAOMatiere;
import quest.dao.IDAOOrdinateur;
import quest.dao.IDAOStagiaire;

public class App {

	public static void main(String[] args) {

		IDAOMatiere daoM=Singleton.getInstance().getDaoMatiere();
		IDAOStagiaire daoS=Singleton.getInstance().getDaoStagiaire();
		IDAOOrdinateur daoO=Singleton.getInstance().getDaoOrdinateur();
		IDAOFiliere daoF=Singleton.getInstance().getDaoFiliere();
		
		
		System.out.println(daoM.findAll());
		System.out.println(daoS.findAll());
		System.out.println(daoO.findAll());
		System.out.println(daoF.findAll());
	}

}
