package netfilm.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import netfilm.context.Singleton;
import netfilm.model.Adresse;
import netfilm.model.Civilite;
import netfilm.model.Client;
import netfilm.model.Compte;


@WebServlet("/client")
public class ClientController extends HttpServlet {
				
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 if(request.getParameter("id")==null)
		 {
		 	List<Client> clients = Singleton.getInstance().getDaoCompte().findAllClient();
		 	request.setAttribute("clients", clients);
			request.setAttribute("civilites", Civilite.values());
		 	this.getServletContext().getRequestDispatcher("/clients.jsp").forward(request, response);
		 }
		 else
		 {
		 	if(request.getParameter("delete") != null)
		 	{
		 		Integer id= Integer.parseInt(request.getParameter("id"));
		 		Singleton.getInstance().getDaoCompte().delete(id);
		 		response.sendRedirect("client");
		 	}
		 	else
		 	{
		 		Integer id= Integer.parseInt(request.getParameter("id"));
		 		Client client = (Client) Singleton.getInstance().getDaoCompte().findById(id);
		 		request.setAttribute("client", client);
		 		request.setAttribute("civilites", Civilite.values());
		 		this.getServletContext().getRequestDispatcher("/updateClient.jsp").forward(request, response);
		 	}
		 }
		 
		 
		
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
			 
			 response.sendRedirect("client");
		}
		else
		{
			 Integer id= Integer.parseInt(request.getParameter("id"));
			 String login = request.getParameter("login");
			 String password = request.getParameter("password");
			 String prenom = request.getParameter("prenom");
			 String nom = request.getParameter("nom");
			 String civilite = request.getParameter("civilite");
			 String numero = request.getParameter("adresse.numero");
			 String voie = request.getParameter("adresse.voie");
			 String ville = request.getParameter("adresse.ville");
			 String cp = request.getParameter("adresse.cp");
			 
			 Client client  = new Client(id,login,password,prenom,nom,Civilite.valueOf(civilite),new Adresse(numero,voie,ville,cp));
			 Singleton.getInstance().getDaoCompte().save(client);
			 
			 response.sendRedirect("client");
		}
	
	}

}
