package netfilm.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import netfilm.model.Adresse;
import netfilm.model.Civilite;
import netfilm.model.Client;
import netfilm.model.Facture;


@WebServlet("/facture")
public class FactureController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		Client client = new Client("login","password","titi","toto",Civilite.NB,new Adresse("1","rue de paris","Paris","75001"));
		Facture facture = new Facture(id,80.50, true,client);
		
		request.setAttribute("facture", facture);
		
		this.getServletContext().getRequestDispatcher("/updateFacture.jsp").forward(request, response);
		
	
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
