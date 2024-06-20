package quest.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import quest.context.Singleton;
import quest.model.Filiere;
import quest.model.Stagiaire;




@WebServlet("/stagiaire")
public class StagiaireController extends HttpServlet {
				
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 if(request.getParameter("id")==null)
		 {
		 	List<Stagiaire> stagiaires = Singleton.getInstance().getDaoStagiaire().findAll();
		 	List<Filiere> filieres = Singleton.getInstance().getDaoFiliere().findAll();
		 	request.setAttribute("filieres", filieres);
		 	
		 	request.setAttribute("stagiaires", stagiaires);
		 	this.getServletContext().getRequestDispatcher("/WEB-INF/stagiaires.jsp").forward(request, response);
		 }
		 else
		 {
		 	if(request.getParameter("delete") != null)
		 	{
		 		Integer id= Integer.parseInt(request.getParameter("id"));
		 		Singleton.getInstance().getDaoStagiaire().delete(id);
		 		response.sendRedirect("stagiaire");
		 	}
		 	else
		 	{
		 		Integer id= Integer.parseInt(request.getParameter("id"));
		 		Stagiaire stagiaire = Singleton.getInstance().getDaoStagiaire().findById(id);
		 		List<Filiere> filieres = Singleton.getInstance().getDaoFiliere().findAll();
			 	request.setAttribute("filieres", filieres);
		 		request.setAttribute("stagiaire", stagiaire);
		 		this.getServletContext().getRequestDispatcher("/WEB-INF/updateStagiaire.jsp").forward(request, response);
		 	}
		 }
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 if(request.getParameter("id")==null)
		{
			 String nom = request.getParameter("nom");
			 String prenom = request.getParameter("prenom");
			 String email = request.getParameter("email");
			 
			 Integer idFiliere= Integer.parseInt(request.getParameter("filiere.id"));
			 Filiere filiere = (Filiere) Singleton.getInstance().getDaoFiliere().findById(idFiliere);
			 Stagiaire stagiaire = new Stagiaire(nom,prenom,email,filiere);
			 Singleton.getInstance().getDaoStagiaire().save(stagiaire);
			 response.sendRedirect("stagiaire");
		}
		else
		{
			 Integer id= Integer.parseInt(request.getParameter("id"));
			 String nom = request.getParameter("nom");
			 String prenom = request.getParameter("prenom");
			 String email = request.getParameter("email");
			 
			 Integer idFiliere= Integer.parseInt(request.getParameter("filiere.id"));
			 Filiere filiere = (Filiere) Singleton.getInstance().getDaoFiliere().findById(idFiliere);
			 Stagiaire stagiaire = new Stagiaire(nom,prenom,email,filiere);
			 Singleton.getInstance().getDaoStagiaire().save(stagiaire);
			 response.sendRedirect("stagiaire");
		}
	
	}

}
