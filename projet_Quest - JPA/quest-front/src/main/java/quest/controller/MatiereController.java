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
public class MatiereController extends HttpServlet{

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("id")==null){
			List<Matiere> matieres = Singleton.getInstance().getDaoMatiere().findAll();
			request.setAttribute("matieres", matieres);
			this.getServletContext().getRequestDispatcher("/WEB-INF/matiere/matieres.jsp").forward(request, response);
		}
		else if(request.getParameter("delete") != null){
			int id = Integer.parseInt(request.getParameter("id"));
			Singleton.getInstance().getDaoMatiere().delete(id);

			response.sendRedirect("matiere");
		}else{
			int id = Integer.parseInt(request.getParameter("id"));
			Matiere matiere = Singleton.getInstance().getDaoMatiere().findById(id);
			request.setAttribute("matiere", matiere);
			this.getServletContext().getRequestDispatcher("/WEB-INF/matiere/updateMatiere.jsp").forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("id") != null){
			int id = Integer.parseInt(request.getParameter("id"));
			String libelle = request.getParameter("libelle");
			int quest = Integer.parseInt(request.getParameter("id"));
			
			Matiere matiere = new Matiere(id, libelle, quest);
	
			Singleton.getInstance().getDaoMatiere().save(matiere);
	
			response.sendRedirect("matiere");
		}
		
   }
}
