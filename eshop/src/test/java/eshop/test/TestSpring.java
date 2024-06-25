package eshop.test;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;

import eshop.dao.IDAOAchat;
import eshop.dao.IDAOPersonne;
import eshop.dao.IDAOProduit;
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
	IDAOProduit daoProduit;

	@Autowired
	ProduitService produitSrv;

	public void initBdd() 
	{

		//Avec spring data jpa, daoX.save(x) (qui donne => em.merge(x)) l'objet x est direment managed (et donc avec un id)
		//Plus besoin de recuperer le return comme depuis JPA
		Adresse a1 = new Adresse("1","chez moi","ma ville","0000");
		Adresse a2 = new Adresse("6","rue rougemont","Paris","75009");
		Fournisseur f1 = new Fournisseur("Abid","Charly",a2,"AJC"); 


		daoPersonne.save(f1);

		Client c1 = new Client("Jordan","Abid",a1,29,LocalDate.parse("1993-05-01"));

		daoPersonne.save(c1);

		Produit p1 = new Produit("Formation SQL",1500,f1);
		Produit p2 = new Produit("Formation Java",2500,f1);

		produitSrv.insert(p1);
		produitSrv.insert(p2);


		Achat ac1 = new Achat(c1,p1);
		Achat ac2 = new Achat(c1,p2);

		daoAchat.save(ac1);
		daoAchat.save(ac2);
	}

	public void run() 
	{

		//initBdd();
		System.out.println("findParLib (avec @Query) : "+daoProduit.findParLib("Formation SQL"));
		System.out.println("\nfindByLib : "+daoProduit.findByLibelle("Formation SQL"));
		System.out.println("\nfindAllByLib : "+daoProduit.findAllByLibelle("Formation SQL"));
		System.out.println("\ncontaining (equiv à like '%Forma%') : "+daoProduit.findByLibelleContaining("Forma"));



		System.out.println("\nfindByPrix version propre : "+daoProduit.findByPrixBetween(1500, 2000));
		System.out.println("\nfindByPrix version courageux ? (non -_-' ) : "+daoProduit.findByPrixGreaterThanEqualAndPrixLessThanEqual(1500, 2000));
	}
}
