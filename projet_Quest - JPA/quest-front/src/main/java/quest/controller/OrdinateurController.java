package quest.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import quest.context.Singleton;
import quest.model.Matiere;
import quest.model.Ordinateur;
import quest.model.Stagiaire;





@WebServlet("/ordinateur")
public class OrdinateurController extends HttpServlet {

	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		if(request.getParameter("id")==null)
		 {
		 	List<Ordinateur> ordinateurs = Singleton.getInstance().getDaoOrdinateur().findAll();
		 	request.setAttribute("ordinateurs", ordinateurs);
		 	List<Stagiaire> stagiaires = Singleton.getInstance().getDaoStagiaire().findStagiaireBesoinOrdi(null);
		 	request.setAttribute("stagiaires", stagiaires);
		 	
		 	
		 	
		 	this.getServletContext().getRequestDispatcher("/WEB-INF/ordinateurs.jsp").forward(request, response);
		 }
		 else
		 {
		 	if(request.getParameter("delete") != null)
		 	{
		 		Integer id= Integer.parseInt(request.getParameter("id"));
		 		Singleton.getInstance().getDaoMatiere().delete(id);
		 		response.sendRedirect("ordinateur");
		 	}
		 	else
		 	{
		 		Integer id= Integer.parseInt(request.getParameter("id"));
		 		Ordinateur ordinateur = Singleton.getInstance().getDaoOrdinateur().findById(id);
		 		request.setAttribute("ordinateur", ordinateur);
		 		List<Stagiaire> stagiaires = Singleton.getInstance().getDaoStagiaire().findStagiaireBesoinOrdi(id);
			 	request.setAttribute("stagiaires", stagiaires);
			 	
			 	System.out.println();
		 		
		 		this.getServletContext().getRequestDispatcher("/WEB-INF/updateOrdinateur.jsp").forward(request, response);
		 	}
		 }
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		
		String marque = request.getParameter("marque");
		int ram  =  Integer.parseInt(request.getParameter("ram"));
		
		System.out.println(request.getParameter("stagiaire.id"));

		
		Integer id_stagiaire = Integer.parseInt(request.getParameter("stagiaire.id"));
		
		Stagiaire stagiaire= Singleton.getInstance().getDaoStagiaire().findById(id_stagiaire);
		
		Ordinateur ordinateur  = new Ordinateur(marque,ram,stagiaire);
		
		if(request.getParameter("id")!=null)
		{
			Integer id = Integer.parseInt(request.getParameter("id"));
			ordinateur.setId(id);
		}
		
		Singleton.getInstance().getDaoOrdinateur().save(ordinateur);	 
		response.sendRedirect("ordinateur");
	}
	
	

}
