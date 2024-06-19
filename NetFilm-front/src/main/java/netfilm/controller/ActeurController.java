package netfilm.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import netfilm.context.Singleton;
import netfilm.model.Acteur;
import netfilm.model.Adresse;
import netfilm.model.Civilite;
import netfilm.model.Client;

//Changer l'url du Controller
@WebServlet("/acteur")
public class ActeurController extends HttpServlet {
				
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 if(request.getParameter("id")==null)
		 {
		 	List<Acteur> acteurs = Singleton.getInstance().getDaoActeur().findAll();
		 	request.setAttribute("acteurs", acteurs);
		 	this.getServletContext().getRequestDispatcher("/acteurs.jsp").forward(request, response);
		 }
		 else
		 {
		 	
		 }
		 
		 
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 if(request.getParameter("id")==null)
		{
			 String nom = request.getParameter("nom");
			 String prenom = request.getParameter("prenom"); 
			 String numero = request.getParameter("adresse.numero");
			 String voie = request.getParameter("adresse.voie");
			 String ville = request.getParameter("adresse.ville");
			 String cp = request.getParameter("adresse.cp");
			 
			 Acteur acteur  = new Acteur(nom,prenom,new Adresse(numero,voie,ville,cp));
			 Singleton.getInstance().getDaoActeur().save(acteur);
			 
			 response.sendRedirect("acteur");
		}
		else
		{
			
		}
	
	}

}
