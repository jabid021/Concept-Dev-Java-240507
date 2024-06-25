package eshop.dao;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import eshop.config.AppConfig;
import eshop.model.Adresse;
import eshop.model.Fournisseur;
import eshop.model.Produit;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={ AppConfig.class }) 
@Transactional 
@Rollback(true) 
public class DAOProduitTest {

	@Autowired
	IDAOProduit daoProduit;

	@Autowired
	IDAOPersonne daoPersonne;

	@Test
	public void injectionDAOProduit() 
	{
		//Arrange
		//Act
		//Assert
		assertNotNull(daoProduit);
	}


	@Test
	public void findByIdProduitTest() 
	{
		//Arrange
		Adresse a1 = new Adresse("1","chez moi","ma ville","0000");
		Fournisseur f1 = new Fournisseur("Abid","Charly",a1,"societe");
		f1 = (Fournisseur) daoPersonne.save(f1);
		Produit p1 = new Produit("Formation SQL",1500,f1);
		p1=daoProduit.save(p1);

		//Act
		Produit produit = daoProduit.findById(p1.getId());

		//Assert
		assertNotNull(produit);
	}


	
	public void insertProduitTest() 
	{
		
	}

	
	public void deleteProduitTest() 
	{
		
	}
}