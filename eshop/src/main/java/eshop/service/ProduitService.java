package eshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eshop.dao.IDAOProduit;
import eshop.model.Produit;

@Service
public class ProduitService {
	
	@Autowired
	IDAOProduit daoProduit;
	
	public Produit getById(Integer id) 
	{
		if(id==null) 
		{
			throw new RuntimeException("Impossible de find une produit sans id ???");
		}
		Produit produit = daoProduit.findById(id);
		return produit;
	}
	
	public List<Produit> getAll() 
	{
		return daoProduit.findAll();
	}
	
	public Produit insert(Produit produit) 
	{
		if(produit.getLibelle()==null) 
		{
			throw new RuntimeException("Impossible d'insert une produit sans libelle");
		}
		if(produit.getFournisseur()==null) 
		{
			throw new RuntimeException("Impossible d'insert un produit sans fournisseur");
		}
		
		if(produit.getFournisseur().getId()==null) 
		{
			throw new RuntimeException("Impossible d'insert un produit avec un fournisseur sans id ");
		}
		
		return daoProduit.save(produit);
	}
	
	public Produit update(Produit produit) 
	{
		if(produit.getId()==null) 
		{
			throw new RuntimeException("Impossible d'update une produit sans id ???");
		}
		if(produit.getLibelle()==null) 
		{
			throw new RuntimeException("Impossible d'insert une produit sans libelle");
		}
		if(produit.getFournisseur()==null) 
		{
			throw new RuntimeException("Impossible d'insert un produit sans fournisseur");
		}
		
		if(produit.getFournisseur().getId()==null) 
		{
			throw new RuntimeException("Impossible d'insert un produit avec un fournisseur sans id ");
		}
		return daoProduit.save(produit);
	}
	
	public void deleteById(Integer id) 
	{
		if(id==null) 
		{
			throw new RuntimeException("Impossible de supprimer une produit sans id ???");
		}
		daoProduit.delete(id);
	}
	
	public void delete(Produit produit) 
	{
		if(produit.getId()==null) 
		{
			throw new RuntimeException("Impossible de supprimer une produit sans id ???");
		}
		deleteById(produit.getId());
	}

}
