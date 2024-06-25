package eshop.test;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;

import eshop.dao.IDAOAchat;
import eshop.dao.IDAOPersonne;
import eshop.model.Achat;
import eshop.model.Adresse;
import eshop.model.Client;
import eshop.model.Fournisseur;
import eshop.model.Produit;
import eshop.service.ProduitService;

public class TestSpring {

	
	@Autowired
	IDAOAchat daoAchat;
	
	@Autowired
	IDAOPersonne daoPersonne;
	
	@Autowired
	ProduitService produitSrv;
	
	public void initBdd() 
	{
		Adresse a1 = new Adresse("1","chez moi","ma ville","0000");
		Adresse a2 = new Adresse("6","rue rougemont","Paris","75009");
		Fournisseur f1 = new Fournisseur("Abid","Charly",a2,"AJC"); 
	
		
		f1 = (Fournisseur) daoPersonne.save(f1);
		
		Client c1 = new Client("Jordan","Abid",a1,29,LocalDate.parse("1993-05-01"));
		
		c1 = (Client) daoPersonne.save(c1);
		
		Produit p1 = new Produit("Formation SQL",1500,f1);
		Produit p2 = new Produit("Formation Java",2500,f1);
		
		p1=produitSrv.insert(p1);
		p2=produitSrv.insert(p2);
		
		
		Achat ac1 = new Achat(c1,p1);
		Achat ac2 = new Achat(c1,p2);
		
		daoAchat.save(ac1);
		daoAchat.save(ac2);
	}
	
	public void run() 
	{
	
		//initBdd();
		
		System.out.println(daoPersonne.findAll());
		System.out.println(produitSrv.getAll());
	}
}
