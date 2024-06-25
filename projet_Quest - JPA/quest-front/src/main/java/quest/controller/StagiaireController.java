package quest.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import quest.model.Filiere;
import quest.model.Stagiaire;
import quest.service.FiliereService;
import quest.service.StagiaireService;


@WebServlet("/stagiaire")
public class StagiaireController extends HttpServlet {
	
	@Autowired
	StagiaireService stagiaireSrv;
	
	@Autowired
	FiliereService filiereSrv;
	
	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 if(request.getParameter("id")==null)
		 {
		 	List<Stagiaire> stagiaires = stagiaireSrv.getAll();
		 	List<Filiere> filieres = filiereSrv.getAll();
		 	request.setAttribute("stagiaires", stagiaires);
		 	request.setAttribute("filieres", filieres);
		 	this.getServletContext().getRequestDispatcher("/WEB-INF/stagiaires.jsp").forward(request, response);
		 }
		 else
		 {
		 	if(request.getParameter("delete") != null)
		 	{
		 		Integer id= Integer.parseInt(request.getParameter("id"));
		 		stagiaireSrv.deleteById(id);
		 		response.sendRedirect("stagiaire");
		 	}
		 	else
		 	{
		 		Integer id= Integer.parseInt(request.getParameter("id"));
		 		Stagiaire stagiaire = stagiaireSrv.getById(id);
		 		List<Filiere> filieres = filiereSrv.getAll();
		 		request.setAttribute("stagiaire", stagiaire);
		 		request.setAttribute("filieres", filieres);
		 		this.getServletContext().getRequestDispatcher("/WEB-INF/updateStagiaire.jsp").forward(request, response);
		 	}
		 }
		 
		 
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 if(request.getParameter("id")==null)
		{
			 String email = request.getParameter("email");
			 String prenom = request.getParameter("prenom");
			 String nom = request.getParameter("nom");
			 Integer idFiliere= Integer.parseInt(request.getParameter("filiere.id"));
			 Filiere filiere = filiereSrv.getById(idFiliere);
			 
			 Stagiaire stagiaire  = new Stagiaire(nom,prenom,email,filiere);
			 stagiaireSrv.insert(stagiaire);
			 
			 response.sendRedirect("stagiaire");
		}
		else
		{
			 Integer id= Integer.parseInt(request.getParameter("id"));
			 String email = request.getParameter("email");
			 String prenom = request.getParameter("prenom");
			 String nom = request.getParameter("nom");
			 Integer idFiliere= Integer.parseInt(request.getParameter("filiere.id"));
			 Filiere filiere = filiereSrv.getById(idFiliere);
			 
			 Stagiaire stagiaire  = new Stagiaire(id,nom,prenom,email,filiere);
			 stagiaireSrv.update(stagiaire);
			 
			 response.sendRedirect("stagiaire");
		}
	
	}

}
