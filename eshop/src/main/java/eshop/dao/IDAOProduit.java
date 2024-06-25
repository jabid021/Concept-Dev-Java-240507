package eshop.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import eshop.model.Produit;

public interface IDAOProduit extends JpaRepository<Produit,Integer> {

	@Query("SELECT p from Produit p where p.libelle=:libelle")
	public List<Produit> findParLib(@Param("libelle") String libelle);
	
	//findBy / findAll font la même chose, le nom de la fonction est juste plus clair avec all
	//pour Spring, le plus important, c'est le type de retour, avec une List<Produit> il deduit tout seul la notion de findAll
	public List<Produit> findByLibelle(String libelle);
	public List<Produit> findAllByLibelle(String libelle);
	
	//Containing permet de générer une requete avec like '%recherche%'
	public List<Produit> findByLibelleContaining(String recherche);
	
	
	//Les deux fonctions font la même chose, pour comparer prix avec 2 bornes (a et b), between est bien plus rapide
	//La 2e version pourrait servir à comparer prix >='a' and date <='b' par exemple
	//d'ou l'importance pour Spring de repeter le nom de l'attribut prix deux fois !
	public List<Produit> findByPrixBetween(double min,double max);
	public List<Produit> findByPrixGreaterThanEqualAndPrixLessThanEqual(double a,double b);
	
	
	
	
}
