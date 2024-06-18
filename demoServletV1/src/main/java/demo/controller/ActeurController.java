package demo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import netfilm.context.Singleton;
import netfilm.model.Acteur;


@WebServlet("/acteur")
public class ActeurController extends HttpServlet {
	
    
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	Integer id = Integer.parseInt(request.getParameter("id"));
	
	Acteur acteurBdd = Singleton.getInstance().getDaoActeur().findById(id);
	List<Acteur> listeActeurs = Singleton.getInstance().getDaoActeur().findAll();
	//Attacher la variable acteur avant d'envoyer vers la jsp
	request.setAttribute("acteur",acteurBdd);
	request.setAttribute("acteurs",listeActeurs);
	//Envoyer vers la vue modifierActeur.jsp
	this.getServletContext().getRequestDispatcher("/modifierActeur.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
