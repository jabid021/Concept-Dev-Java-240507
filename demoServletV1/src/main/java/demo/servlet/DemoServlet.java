package demo.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import netfilm.context.Singleton;
import netfilm.model.Acteur;

@WebServlet("/demo")
public class DemoServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		Integer id = Integer.parseInt(request.getParameter("id"));
		
		Acteur acteur = Singleton.getInstance().getDaoActeur().findById(id);
		
		response.getWriter().println("<html>");
		response.getWriter().println("<body>");
		response.getWriter().println("<h1>Fiche de l'acteur "+id+"</h1>");
		response.getWriter().println("<table>");
		response.getWriter().println("<tr><th>Prenom</th><th>Nom</th><th>Adresse</th></tr>");
		response.getWriter().println("<tr><th>"+acteur.getPrenom()+"</th><th>"+acteur.getNom()+"</th><th>"+acteur.getAdresse()+"</th></tr>");
		response.getWriter().println("</table>");
		response.getWriter().println("</body>");
		response.getWriter().println("</html>");
		
		
		System.out.println("On est en get (Demo servlet)");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("On est en post(Demo servlet)");
	}

}
