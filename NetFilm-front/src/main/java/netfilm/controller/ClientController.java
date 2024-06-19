package netfilm.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import netfilm.context.Singleton;
import netfilm.model.Adresse;
import netfilm.model.Civilite;
import netfilm.model.Client;
import netfilm.model.Facture;


@WebServlet("/client")
public class ClientController extends HttpServlet {
				
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 if(id==null)
		 {
		 	findAll();
		 }
		 else
		 {
		 	if(delete != null)
		 	{
		 		//delete
		 	}
		 	else
		 	{
		 		//findById	
		 	}
		 }
		 
		 
		*/
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 if(request.getParameter("id")==null)
		{
			 String login = request.getParameter("login");
			 String password = request.getParameter("password");
			 String prenom = request.getParameter("prenom");
			 String nom = request.getParameter("nom");
			 String civilite = request.getParameter("civilite");
			 String numero = request.getParameter("adresse.numero");
			 String voie = request.getParameter("adresse.voie");
			 String ville = request.getParameter("adresse.ville");
			 String cp = request.getParameter("adresse.cp");
			 
			 Client client  = new Client(login,password,prenom,nom,Civilite.valueOf(civilite),new Adresse(numero,voie,ville,cp));
			 Singleton.getInstance().getDaoCompte().save(client);
			 System.out.println("SAVE DU CLIENT EN BDD");
		}
		else
		{
			//save(update)
		}
	
	}

}
