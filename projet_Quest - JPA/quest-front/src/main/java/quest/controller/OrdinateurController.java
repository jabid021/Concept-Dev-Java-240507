package quest.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import quest.context.Singleton;
import quest.model.Ordinateur;
import quest.model.Stagiaire;



@WebServlet("/ordinateur")
public class OrdinateurController extends HttpServlet {
				
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 if(request.getParameter("id")==null)
		 {
		 	List<Ordinateur> ordinateurs = Singleton.getInstance().getDaoOrdinateur().findAll();
		 	List<Stagiaire> stagiaires = Singleton.getInstance().getDaoStagiaire().findAll();
		 	request.setAttribute("ordinateurs", ordinateurs);
		 	request.setAttribute("stagiaires", stagiaires);
		 	this.getServletContext().getRequestDispatcher("/ordinateurs.jsp").forward(request, response);
		 }
		 else
		 {
		 	if(request.getParameter("delete") != null)
		 	{
		 		Integer id= Integer.parseInt(request.getParameter("id"));
		 		Singleton.getInstance().getDaoOrdinateur().delete(id);
		 		response.sendRedirect("ordinateur");
		 	}
		 	else
		 	{
		 		Integer id= Integer.parseInt(request.getParameter("id"));
		 		Ordinateur ordinateur = Singleton.getInstance().getDaoOrdinateur().findById(id);
		 		List<Stagiaire> stagiaires = Singleton.getInstance().getDaoStagiaire().findAll();
		 		request.setAttribute("ordinateur", ordinateur);
		 		request.setAttribute("stagiaires", stagiaires);
		 		this.getServletContext().getRequestDispatcher("/updateOrdinateur.jsp").forward(request, response);
		 	}
	}}
		 
		 
		


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 if(request.getParameter("id")==null)
		{
			 String marque = request.getParameter("marque");
			 Integer ram= Integer.parseInt(request.getParameter("ram"));
			 Integer idStagiaire= Integer.parseInt(request.getParameter("stagiaire.id"));
			 Stagiaire stagiaire = Singleton.getInstance().getDaoStagiaire().findById(idStagiaire);
			 Ordinateur ordinateur  = new Ordinateur(marque,ram,stagiaire);
			 
			 Singleton.getInstance().getDaoOrdinateur().save(ordinateur); 
			 response.sendRedirect("ordinateur");
		}
		else
		{
			 Integer id= Integer.parseInt(request.getParameter("id"));
			 String marque = request.getParameter("marque");
			 Integer ram= Integer.parseInt(request.getParameter("ram"));
			 Integer idStagiaire= Integer.parseInt(request.getParameter("stagiaire.id"));
			 Stagiaire stagiaire = Singleton.getInstance().getDaoStagiaire().findById(idStagiaire); 
			 Ordinateur ordinateur  = new Ordinateur(id,marque,ram,stagiaire);
			 
			 Singleton.getInstance().getDaoOrdinateur().save(ordinateur);
			 response.sendRedirect("ordinateur");
		}
	
	}

}
