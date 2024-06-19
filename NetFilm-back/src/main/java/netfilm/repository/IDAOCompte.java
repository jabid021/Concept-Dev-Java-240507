package netfilm.repository;

import java.util.List;

import netfilm.model.Admin;
import netfilm.model.Client;
import netfilm.model.Compte;

public interface IDAOCompte extends IDAO<Compte,Integer> {

	public List<Client> findAllClient();
	public List<Admin> findAllAdmin();
	
}
