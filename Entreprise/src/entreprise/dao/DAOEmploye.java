package entreprise.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import entreprise.model.Departement;
import entreprise.model.Employe;

public class DAOEmploye implements IDAO<Employe,Integer> {

	@Override
	public Employe findById(Integer id) {
		DAODepartement daoDepartement = new DAODepartement();
		Employe employe = null;
		try(
				Connection conn  = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
				PreparedStatement ps = conn.prepareStatement("SELECT * from emp where empno=?");
				) 
		{
			Class.forName("com.mysql.jdbc.Driver");
			ps.setInt(1, id);

			ResultSet rs =  ps.executeQuery();

			while(rs.next()) 
			{
				Integer comm = (Integer) rs.getObject("comm");

				Departement departement = daoDepartement.findById(rs.getInt("deptno"));
				Employe manager = findById(rs.getInt("mgr")) ;
				employe = new Employe(rs.getInt("empno"), rs.getString("ename"),rs.getString("job"),LocalDate.parse(rs.getString("hiredate")),rs.getInt("sal"),comm,manager,departement );

			}
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		return employe;
	}

	@Override
	public List<Employe> findAll() {
		DAODepartement daoDepartement = new DAODepartement();
		List<Employe> employes=new ArrayList();
		try(
				Connection conn  = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
				PreparedStatement ps = conn.prepareStatement("SELECT * from emp employe ");
				) 
		{
			Class.forName("com.mysql.jdbc.Driver");

			ResultSet rs =  ps.executeQuery();

			while(rs.next()) 
			{
				Integer comm = (Integer) rs.getObject("comm");
				Departement departement = daoDepartement.findById(rs.getInt("deptno"));
				Employe manager = findById(rs.getInt("mgr")) ;
				Employe employe = new Employe(rs.getInt("empno"), rs.getString("ename"),rs.getString("job"),LocalDate.parse(rs.getString("hiredate")),rs.getInt("sal"),comm,manager,departement );

				employes.add(employe);
			}
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		return employes;
	}

	@Override
	public void insert(Employe employe) {
		try(
				Connection conn  = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
				PreparedStatement ps = conn.prepareStatement("INSERT INTO emp (ename,job,mgr,hiredate,sal,comm,deptno,empno) VALUES (?,?,?,?,?,?,?,?)");
				) 
		{
			Class.forName("com.mysql.jdbc.Driver");
			ps.setString(1, employe.getEname());
			ps.setString(2, employe.getJob());
			if(employe.getManager()==null) 
			{
				ps.setObject(3, null);
			}
			else 
			{
				ps.setInt(3, employe.getManager().getId());
			}

			ps.setString(4, employe.getHiredate().toString());

			ps.setInt(5, employe.getSal());

			if(employe.getComm()==null) 
			{
				ps.setObject(6, null);
			}
			else 
			{
				ps.setInt(6, employe.getComm());
			}
			if(employe.getDepartement()==null) 
			{
				ps.setObject(7, null);
			}
			else 
			{
				ps.setInt(7, employe.getDepartement().getDeptno());
			}

			ps.setInt(8, employe.getId());

			ps.executeUpdate();

		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}	
	}

	@Override
	public void update(Employe employe) {
		try(
				Connection conn  = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
				PreparedStatement ps = conn.prepareStatement("UPDATE emp set ename=?, job=?, mgr=?,hiredate=?,sal=?,comm=?,deptno=? where empno=?");
				) 
		{
			Class.forName("com.mysql.jdbc.Driver");
			ps.setString(1, employe.getEname());
			ps.setString(2, employe.getJob());
			if(employe.getManager()==null) 
			{
				ps.setObject(3, null);
			}
			else 
			{
				ps.setInt(3, employe.getManager().getId());
			}

			ps.setString(4, employe.getHiredate().toString());

			ps.setInt(5, employe.getSal());

			if(employe.getComm()==null) 
			{
				ps.setObject(6, null);
			}
			else 
			{
				ps.setInt(6, employe.getComm());
			}
			if(employe.getDepartement()==null) 
			{
				ps.setObject(7, null);
			}
			else 
			{
				ps.setInt(7, employe.getDepartement().getDeptno());
			}

			ps.setInt(8, employe.getId());

			ps.executeUpdate();

		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}	
	}

	@Override
	public void delete(Integer id) {
		try(
				Connection conn  = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
				PreparedStatement ps = conn.prepareStatement("delete from emp where empno=?");
				PreparedStatement ps2 = conn.prepareStatement("UPDATE emp set mgr = null where mgr=?");
				) 
		{
			Class.forName("com.mysql.jdbc.Driver");
			ps.setInt(1, id);
			ps.executeUpdate();
			ps2.setInt(1, id);
			ps2.executeUpdate();

		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}	
	}




	public Employe findByEnameAndJob(String ename,String job) 
	{
		Employe employe=null;
		try(
				Connection conn  = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
				Statement st = conn.createStatement();
			) 
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			ResultSet rs =  st.executeQuery("SELECT * from emp where ename = '"+ename+"' and job='"+job+"'");
			while(rs.next()) 
			{
				employe = new Employe(rs.getInt("empno"), rs.getString("ename"),rs.getString("job"),LocalDate.parse(rs.getString("hiredate")),rs.getInt("sal"),rs.getInt("comm"),null,null);
			}
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		//Contrairement aux autres fonctions, utilisez ici un Statement pour laisser apparaitre la faille d'injection SQL
		return employe;
	}
}
