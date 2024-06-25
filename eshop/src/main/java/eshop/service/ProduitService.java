package eshop.service;

import java.util.List;
import java.util.Optional;

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

		Optional<Produit> opt = daoProduit.findById(id);
		if(opt.isEmpty()) 
		{
			return null;
		}
		else 
		{
			return opt.get();
		}
	}

	public List<Produit> getAll() 
	{
		return daoProduit.findAll();
	}

	public List<Produit> getAllByLibelle(String libelle)
	{
		return daoProduit.findByLibelle(libelle);
	}

	public List<Produit> getAllByPrixBetween(double min,double max)
	{
		return daoProduit.findByPrixBetween(min, max);
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
		daoProduit.deleteById(id);
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
