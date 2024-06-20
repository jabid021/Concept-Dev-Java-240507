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
import netfilm.model.Facture;


@WebServlet("/facture")
public class FactureController extends HttpServlet {
				
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 if(request.getParameter("id")==null)
		 {
		 	List<Facture> factures = Singleton.getInstance().getDaoFacture().findAll();
		 	List<Client> clients = Singleton.getInstance().getDaoCompte().findAllClient();
		 	request.setAttribute("clients", clients);
		 	
		 	request.setAttribute("factures", factures);
		 	this.getServletContext().getRequestDispatcher("/WEB-INF/factures.jsp").forward(request, response);
		 }
		 else
		 {
		 	if(request.getParameter("delete") != null)
		 	{
		 		Integer id= Integer.parseInt(request.getParameter("id"));
		 		Singleton.getInstance().getDaoFacture().delete(id);
		 		response.sendRedirect("facture");
		 	}
		 	else
		 	{
		 		Integer id= Integer.parseInt(request.getParameter("id"));
		 		Facture facture = Singleton.getInstance().getDaoFacture().findById(id);
		 		List<Client> clients = Singleton.getInstance().getDaoCompte().findAllClient();
			 	request.setAttribute("clients", clients);
		 		request.setAttribute("facture", facture);
		 		this.getServletContext().getRequestDispatcher("/WEB-INF/updateFacture.jsp").forward(request, response);
		 	}
		 }
		 
		 
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 if(request.getParameter("id")==null)
		{
			 double prix = Double.parseDouble(request.getParameter("prix"));
			 boolean valide = (request.getParameter("valide")!=null);
			 Integer idClient= Integer.parseInt(request.getParameter("client.id"));
			 Client client = (Client) Singleton.getInstance().getDaoCompte().findById(idClient);
			 Facture facture = new Facture(prix,valide,client);
			 Singleton.getInstance().getDaoFacture().save(facture);
			 response.sendRedirect("facture");
		}
		else
		{
			 Integer id= Integer.parseInt(request.getParameter("id"));
			 double prix = Double.parseDouble(request.getParameter("prix"));
			 boolean valide = (request.getParameter("valide")!=null);
			 Integer idClient= Integer.parseInt(request.getParameter("client.id"));
			 Client client = (Client) Singleton.getInstance().getDaoCompte().findById(idClient);
			
			 Facture facture = new Facture(id,prix,valide,client);
			 Singleton.getInstance().getDaoFacture().save(facture);
			 response.sendRedirect("facture");
		}
	
	}

}
