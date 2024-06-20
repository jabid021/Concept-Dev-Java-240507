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
		 	request.setAttribute("stagiaires", stagiaires);
		 	
		 	request.setAttribute("ordinateurs", ordinateurs);
		 	this.getServletContext().getRequestDispatcher("/WEB-INF/ordinateurs.jsp").forward(request, response);
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
