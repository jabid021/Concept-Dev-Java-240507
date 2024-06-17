package entreprise.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entreprise.model.Departement;

public class DAODepartement implements IDAO<Departement,Integer> {

	@Override
	public Departement findById(Integer id) {
		Departement departement = null;
		try(
				Connection conn  = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
				PreparedStatement ps = conn.prepareStatement("SELECT * from dept where deptno=?");
			) 
		{
			Class.forName("com.mysql.jdbc.Driver");
			ps.setInt(1, id);
			
			ResultSet rs =  ps.executeQuery();
			
			while(rs.next()) 
			{
				
				departement = new Departement(rs.getInt("deptno"),rs.getString("dname"),rs.getString("loc"));
			}
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		return departement;
	}

	@Override
	public List<Departement> findAll() {
		List<Departement> departements = new ArrayList();
		Departement departement = null;
		try(
				Connection conn  = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
				PreparedStatement ps = conn.prepareStatement("SELECT * from dept");
			) 
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			ResultSet rs =  ps.executeQuery();
			
			while(rs.next()) 
			{
				
				departement = new Departement(rs.getInt("deptno"),rs.getString("dname"),rs.getString("loc"));
				departements.add(departement);
			}
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		return departements;
	}

	@Override
	public void insert(Departement departement) {
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

	@Override
	public void update(Departement departement) {
		try(
				Connection conn  = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
				PreparedStatement ps = conn.prepareStatement("UPDATE dept set dname=?,loc=? where deptno=?");
			) 
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			
			ps.setString(1,departement.getDname());
			ps.setString(2,departement.getLoc());
			ps.setInt(3,departement.getDeptno());
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
				PreparedStatement ps = conn.prepareStatement("DELETE from dept where deptno=?");
			) 
		{
			Class.forName("com.mysql.jdbc.Driver");
		
			ps.setInt(1,id);
			ps.executeUpdate();
			
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}	
	}

}
