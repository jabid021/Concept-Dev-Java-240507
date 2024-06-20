package quest.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import quest.context.Singleton;
import quest.model.Matiere;



@WebServlet("/matiere")
public class MatiereController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("id")==null)
		 {
		 	List<Matiere> matieres = Singleton.getInstance().getDaoMatiere().findAll();
		 	request.setAttribute("matieres", matieres);
		 	this.getServletContext().getRequestDispatcher("/WEB-INF/matieres.jsp").forward(request, response);
		 }
		 else
		 {
		 	if(request.getParameter("delete") != null)
		 	{
		 		Integer id= Integer.parseInt(request.getParameter("id"));
		 		Singleton.getInstance().getDaoMatiere().delete(id);
		 		response.sendRedirect("matiere");
		 	}
		 	else
		 	{
		 		Integer id= Integer.parseInt(request.getParameter("id"));
		 		Matiere matiere = Singleton.getInstance().getDaoMatiere().findById(id);
		 		request.setAttribute("matiere", matiere);
		 		this.getServletContext().getRequestDispatcher("/WEB-INF/updateMatiere.jsp").forward(request, response);
		 	}
		 }
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		String libelle = request.getParameter("libelle");
		int quest = Integer.parseInt(request.getParameter("quest"));
		
		Matiere matiere  = new Matiere(libelle,quest);
		
		if(request.getParameter("id")!=null)
		{
			Integer id = Integer.parseInt(request.getParameter("id"));
			matiere.setId(id);
		}
		
		Singleton.getInstance().getDaoMatiere().save(matiere);
		 
		response.sendRedirect("matiere");
	}
	
	

}
