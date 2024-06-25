package eshop.test;

import eshop.dao.IDAOAchat;
import eshop.dao.IDAOPersonne;

public class TestSpring {

	
	@Autowired
	IDAOAchat daoAchat;
	
	@Autowired
	IDAOPersonne daoPersonne;
	
	@Autowired
	ProduitService produitSrv;
	
	
	public void run() 
	{
		
		System.out.println(daoPersonne.findAll());
		System.out.println(produitSrv.getAll());
	}
}
