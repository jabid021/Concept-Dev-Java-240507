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

		System.out.println(Singleton.getInstance().getDaoStagiaire().findAllDisponibles());
	}

}
