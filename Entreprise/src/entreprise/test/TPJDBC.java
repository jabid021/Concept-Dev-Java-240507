package entreprise.test;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import entreprise.dao.DAODepartement;
import entreprise.dao.DAOEmploye;
import entreprise.model.Departement;
import entreprise.model.Employe;

public class TPJDBC {
	
	
	
	static DAOEmploye daoEmploye = new DAOEmploye();
	static DAODepartement daoDepartement = new DAODepartement();
	
	public static int saisieInt(String msg) {
		Scanner monScanner = new Scanner(System.in);
		System.out.println(msg);
		return monScanner.nextInt();
	}
	public static String saisieString(String msg) {
		Scanner monScanner = new Scanner(System.in);
		System.out.println(msg);
		return monScanner.nextLine();
	}
	

	
	
	
	
	
	public static void menuPrincipal() 
	{
		System.out.println("Gestion des employés");
		System.out.println("1- Afficher tous les employés");
		System.out.println("2- Rechercher un employé par ID");
		System.out.println("3- Ajouter un employé");
		System.out.println("4- Modifier un employé");
		System.out.println("5- Rechercher un employé par ename et job ");
		System.out.println("6- Supprimer un employe");
		System.out.println("7- Stop");
		
		int choix =saisieInt("Choisir un menu");
		switch(choix) 
		{
		case 1 : afficherEmployes();break;
		case 2 : rechercheEmployeID();break;
		case 3 : ajouterEmploye();break;
		case 4 : modifierEmploye();break;
		case 5 : rechercheEmployeEnameEtJob();break;
		case 6 : supprimerEmp();break;
		case 7 : System.exit(0);
		}
		menuPrincipal();
	}
	
	public static void rechercheEmployeID() {
		//Faire saisir un Integer id
		//Si emp est null, afficher que l'id n'existe pas, sinon afficher l'employé
		Integer id = saisieInt("Saisir votre id");
		Employe emp = daoEmploye.findById(id);
		if(emp==null) 
		{
			System.out.println("Cet id n'existe pas");
		}
		else
		{
			System.out.println(emp);
		}
		
		
	}
	public static void afficherEmployes() {
		List<Employe> employes = daoEmploye.findAll();
		//Verifier si la liste est vide, si c'est le cas, afficher qu'elle est vide, sinon afficher chaque employé
		if(employes.isEmpty()) 
		{
			System.out.println("La liste d'employe est vide !");
		}
		for(Employe e : employes) 
		{
			System.out.println(e);
		}
		
		
	}
	
	public static void supprimerEmp() 
	{
		afficherEmployes();
		Integer id = saisieInt("Saisir l'id de l'employe à delete");
		daoEmploye.delete(id);
	}
	
	
	
	public static void afficherDepartements() {
		List<Departement> departements = daoDepartement.findAll();
		//Verifier si la liste est vide, si c'est le cas, afficher qu'elle est vide, sinon afficher chaque employé
		if(departements.isEmpty()) 
		{
			System.out.println("La liste des departements est vide !");
		}
		for(Departement d : departements) 
		{
			System.out.println(d);
		}
		
		
	}
	public static void rechercheEmployeEnameEtJob() {
		//Faire saisir ename et job
		String ename=saisieString("Saisir ename");
		String job = saisieString("Saisir job");
		Employe emp = daoEmploye.findByEnameAndJob(ename, job);
		if(emp==null) 
		{
			System.out.println("Aucun employe avec cet ename / job");
		}
		else 
		{
			System.out.println(emp);
		}
		//Verifier si emp est null, si c'est le cas, afficher que cet employé n'existe pas, sinon afficher l'employé
		
		
		
		
		
		
		//**********En faisant vos test, vous devez être capable d'injecter votre propre code SQL pour afficher les informations de KING sans même connaitre son job*************
	}
	
	public static void ajouterEmploye() {
		//Faire saisir les informations d'un employé (ne pas prendre en compte le manager et le département, laisser null)
		Integer id = saisieInt("Saisir votre matricule");
		String nom = saisieString("Saisir votre nom");
		String embauche = saisieString("Saisir votre date d'embauche (yyyy-mm-dd)");
		String job = saisieString("Saisir votre job");
		int salaire = saisieInt("Saisir votre salaire");
		
		String choix = saisieString("Avez vous une commission ? y/n");
		Integer comm=null;
		if(choix.equals("y")) 
		{
			comm = saisieInt("Saisir votre comm");
		}
		//Integer comm = saisieInt("Saisir votre comm (-1 si vous n'avez pas de comm)");
		//if(comm==-1) {comm=null;}
		
		choix = saisieString("Avez vous un manager ? y/n");
		Employe manager=null;
		
		if(choix.equals("y")) 
		{
			afficherEmployes();
			int  idManager = saisieInt("Quel est l'id de votre manager ?");
			manager = daoEmploye.findById(idManager);
		}
		
		
		choix = saisieString("Avez vous un departement ? y/n");
		Departement departement=null;
		
		if(choix.equals("y")) 
		{
			afficherDepartements();
			Integer idDept = saisieInt("Saisir l'id du departement");
			departement = daoDepartement.findById(idDept);
		}
		
		Employe emp=new Employe(id, nom, job, LocalDate.parse(embauche), salaire, comm, manager, departement);
		daoEmploye.insert(emp);
		
	}
	public static void modifierEmploye() {
		afficherEmployes();
		Integer id = saisieInt("Saisir votre matricule pour update");
		String nom = saisieString("Saisir votre nom");
		String embauche = saisieString("Saisir votre date d'embauche (yyyy-mm-dd)");
		String job = saisieString("Saisir votre job");
		int salaire = saisieInt("Saisir votre salaire");
		
		String choix = saisieString("Avez vous une commission ? y/n");
		Integer comm=null;
		if(choix.equals("y")) 
		{
			comm = saisieInt("Saisir votre comm");
		}
		//Integer comm = saisieInt("Saisir votre comm (-1 si vous n'avez pas de comm)");
		//if(comm==-1) {comm=null;}
		
		choix = saisieString("Avez vous un manager ? y/n");
		Employe manager=null;
		
		if(choix.equals("y")) 
		{
			afficherEmployes();
			int  idManager = saisieInt("Quel est l'id de votre manager ?");
			manager = daoEmploye.findById(idManager);
		}
		
		
		choix = saisieString("Avez vous un departement ? y/n");
		Departement departement=null;
		
		if(choix.equals("y")) 
		{
			afficherDepartements();
			Integer idDept = saisieInt("Saisir l'id du departement");
			departement = daoDepartement.findById(idDept);
		}
		
		Employe emp=new Employe(id, nom, job, LocalDate.parse(embauche), salaire, comm, manager, departement);
		
		daoEmploye.update(emp);
		
	}
	
	

	
	
	public static void main(String[] args) {
	
		
		menuPrincipal();
	}
}
