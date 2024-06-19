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

//Changer l'url du Controller
@WebServlet("")
public class ActeurController extends HttpServlet {
				
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 if(request.getParameter("id")==null)
		 {
		 	//CODER ICI
		 }
		 else
		 {
		 	
		 }
		 
		 
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 if(request.getParameter("id")==null)
		{
			 //CODER ICI
		}
		else
		{
			
		}
	
	}

}
