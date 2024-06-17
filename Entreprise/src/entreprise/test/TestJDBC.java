package entreprise.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Scanner;

import entreprise.model.Departement;
import entreprise.model.Employe;

public class TestJDBC {
	
	//Version Windows / Linux
	static String loginBdd= "root";
	static String passwordBdd = "root";
	static String urlBdd = "jdbc:mysql://localhost:3306/scott";
	
	
	//Version Mac 
	/*static String loginBdd= "root";
	static String passwordBdd = "root";
	static String urlBdd = "jdbc:mysql://localhost:8889/scott";
	*/
	
	//JDBC => Java DataBase Connectivity.
	
	
	public static String saisieString(String message) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println(message);
		return sc.nextLine();
	}
	
	public static void demoSelectDepartement() 
	{
		try(
				Connection conn  = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
				Statement st = conn.createStatement();
			) 
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			ResultSet rs =  st.executeQuery("SELECT * from dept");
			
			while(rs.next()) 
			{
				Departement d = new Departement(rs.getInt("deptno"),rs.getString("dname"),rs.getString("loc"));
				System.out.println(d);
			}
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		
	}
	
	public static void demoSelectEmploye() 
	{
		try(
				Connection conn  = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
				Statement st = conn.createStatement();
			) 
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			ResultSet rs =  st.executeQuery("SELECT * from emp employe join emp manager on employe.mgr=manager.empno JOIN dept on employe.deptno = dept.deptno");
			
			while(rs.next()) 
			{
				Departement departement = new Departement(rs.getInt("dept.deptno"),rs.getString("dname"),rs.getString("loc"));
				Employe manager = new Employe(rs.getInt("manager.empno"), rs.getString("manager.ename"),rs.getString("manager.job")  ,LocalDate.parse(rs.getString("manager.hiredate")),rs.getInt("manager.sal"),rs.getInt("manager.comm"),null,null );
				Employe employe = new Employe(rs.getInt("employe.empno"), rs.getString("employe.ename"),rs.getString("employe.job"),LocalDate.parse(rs.getString("employe.hiredate")),rs.getInt("employe.sal"),rs.getInt("employe.comm"),manager,departement );
				System.out.println(employe);
			}
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		
	}
	
	
	public static void demoInsertDepartement(Departement departement) 
	{
		try(
				Connection conn  = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
				Statement st = conn.createStatement();
			) 
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			st.executeUpdate("INSERT INTO dept (deptno,dname,loc) VALUES ("+departement.getDeptno()+",'"+departement.getDname()+"','"+departement.getLoc()+"')");
			
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}	
	}
	
	public static void demoConnect(String login, String password) 
	{
		try(
				Connection conn  = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
				Statement st = conn.createStatement();
			) 
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			ResultSet rs =  st.executeQuery("SELECT * from emp where ename = '"+login+"' and job='"+password+"'");
			System.out.println("SELECT * from emp where ename = '"+login+"' and job='"+password+"' ");
			while(rs.next()) 
			{
				Employe employe = new Employe(rs.getInt("empno"), rs.getString("ename"),rs.getString("job"),LocalDate.parse(rs.getString("hiredate")),rs.getInt("sal"),rs.getInt("comm"),null,null);
				System.out.println(employe);
			}
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		
	}
	
	
	
	//-------------A partir d'ici, requetes secures !-----------------------------
	
	
	public static void demoSelectDepartementSecure() 
	{
		try(
				Connection conn  = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
				PreparedStatement ps = conn.prepareStatement("SELECT * from dept");
			) 
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			ResultSet rs =  ps.executeQuery();
			
			while(rs.next()) 
			{
				Departement d = new Departement(rs.getInt("deptno"),rs.getString("dname"),rs.getString("loc"));
				System.out.println(d);
			}
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		
	}
	
	public static void demoSelectEmployeSecure() 
	{
		try(
				Connection conn  = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
				PreparedStatement ps = conn.prepareStatement("SELECT * from emp employe join emp manager on employe.mgr=manager.empno JOIN dept on employe.deptno = dept.deptno");
			) 
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			ResultSet rs =  ps.executeQuery();
			
			while(rs.next()) 
			{
				Departement departement = new Departement(rs.getInt("dept.deptno"),rs.getString("dname"),rs.getString("loc"));
				Employe manager = new Employe(rs.getInt("manager.empno"), rs.getString("manager.ename"),rs.getString("manager.job"),LocalDate.parse(rs.getString("manager.hiredate")),rs.getInt("manager.sal"),rs.getInt("manager.comm"),null,null );
				Employe employe = new Employe(rs.getInt("employe.empno"), rs.getString("employe.ename"),rs.getString("employe.job"),LocalDate.parse(rs.getString("employe.hiredate")),rs.getInt("employe.sal"),rs.getInt("employe.comm"),manager,departement );
				System.out.println(employe);
			}
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		
	}
	
	
	public static void demoInsertDepartementSecure(Departement departement) 
	{
		try(
				Connection conn  = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
				PreparedStatement ps = conn.prepareStatement("INSERT INTO dept (deptno,dname,loc) VALUES (?,?,?)");
			) 
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			ps.setInt(1,departement.getDeptno());
			ps.setString(2,departement.getDname());
			ps.setString(3,departement.getLoc());
			
			ps.executeUpdate();
			
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}	
	}
	
	public static void demoConnectSecure(String login, String password) 
	{
	    try(
	            // Établissement de la connexion à la base de données avec les informations de connexion fournies
	            Connection conn  = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
	            // Préparation de la requête SQL pour récupérer les données de l'employé en fonction du nom d'utilisateur (login) et du mot de passe fournis
	            PreparedStatement ps = conn.prepareStatement("SELECT * from emp where ename = ? and job=?");
	        ) 
	    {
	        // Chargement du pilote JDBC pour la base de données MySQL
	        Class.forName("com.mysql.jdbc.Driver");
	        
	        // Attribution des valeurs aux paramètres de la requête SQL
	        ps.setString(1, login);
	        ps.setString(2, password);
	        
	        // Exécution de la requête et récupération du résultat dans un ResultSet
	        ResultSet rs =  ps.executeQuery();
	        while(rs.next()) 
	        {
	            // Création d'un objet Employe à partir des données récupérées dans le ResultSet
	            Employe employe = new Employe(rs.getInt("empno"), rs.getString("ename"),rs.getString("job"),LocalDate.parse(rs.getString("hiredate")),rs.getInt("sal"),rs.getInt("comm"),null,null);
	            // Affichage de l'employé trouvé
	            System.out.println(employe);
	        }
	    }
	    catch(Exception e) 
	    {
	        // Gestion des exceptions, en cas d'erreur, affichage de la trace de la pile d'exécution
	        e.printStackTrace();
	    }
	    
	}
	
	
	public static void main(String[] args) {
		
		Departement d = new Departement(60,"Formation","Paris");
		
		//demoInsertDepartement(d);
		//demoSelectDepartement();
		//demoSelectEmploye();	
		
		String login = saisieString("Saisir votre login (ename)");
		String password = saisieString("Saisir votre password (job)");
		demoConnect(login, password);
	
		
		
		
	}

}
