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

import quest.model.Matiere;
import quest.service.MatiereService;


@WebServlet("/matiere")
public class MatiereController extends HttpServlet {
	
	@Autowired
	MatiereService matiereSrv;
	
	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 if(request.getParameter("id")==null)
		 {
		 	List<Matiere> matieres = matiereSrv.getAll();
		 	request.setAttribute("matieres", matieres);
		 	this.getServletContext().getRequestDispatcher("/WEB-INF/matieres.jsp").forward(request, response);
		 }
		 else
		 {
		 	if(request.getParameter("delete") != null)
		 	{
		 		Integer id= Integer.parseInt(request.getParameter("id"));
		 		matiereSrv.deleteById(id);
		 		response.sendRedirect("matiere");
		 	}
		 	else
		 	{
		 		Integer id= Integer.parseInt(request.getParameter("id"));
		 		Matiere matiere = matiereSrv.getById(id);
		 		request.setAttribute("matiere", matiere);
		 		this.getServletContext().getRequestDispatcher("/WEB-INF/updateMatiere.jsp").forward(request, response);
		 	}
		 }
		 
		 
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 if(request.getParameter("id")==null)
		{
			 String libelle = request.getParameter("libelle");
			 Integer quest= Integer.parseInt(request.getParameter("quest"));
			
			 
			 Matiere matiere  = new Matiere(libelle,quest);
			 matiereSrv.insert(matiere);
			 
			 response.sendRedirect("matiere");
		}
		else
		{
			 Integer id= Integer.parseInt(request.getParameter("id"));
			 String libelle = request.getParameter("libelle");
			 Integer quest= Integer.parseInt(request.getParameter("quest"));
			
			 
			 Matiere matiere  = new Matiere(id,libelle,quest);
			 matiereSrv.update(matiere);
			 
			 response.sendRedirect("matiere");
		}
	
	}

}
