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

import quest.dao.IDAOOrdinateur;
import quest.dao.IDAOStagiaire;
import quest.model.Ordinateur;
import quest.model.Stagiaire;


@WebServlet("/ordinateur")
public class OrdinateurController extends HttpServlet {

	@Autowired
	IDAOOrdinateur daoOrdinateur;

	@Autowired
	IDAOStagiaire daoStagiaire;

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(request.getParameter("id")==null)
		{
			List<Ordinateur> ordinateurs = daoOrdinateur.findAll();
			List<Stagiaire> stagiaires = daoStagiaire.findAllDisponibles();
			request.setAttribute("ordinateurs", ordinateurs);
			request.setAttribute("stagiaires", stagiaires);
			this.getServletContext().getRequestDispatcher("/WEB-INF/ordinateurs.jsp").forward(request, response);
		}
		else
		{
			if(request.getParameter("delete") != null)
			{
				Integer id= Integer.parseInt(request.getParameter("id"));
				daoOrdinateur.delete(id);
				response.sendRedirect("ordinateur");
			}
			else
			{
				Integer id= Integer.parseInt(request.getParameter("id"));
				Ordinateur ordinateur = daoOrdinateur.findById(id);
				List<Stagiaire> stagiaires = daoStagiaire.findAllDisponibles();
				request.setAttribute("ordinateur", ordinateur);
				request.setAttribute("stagiaires", stagiaires);
				this.getServletContext().getRequestDispatcher("/WEB-INF/updateOrdinateur.jsp").forward(request, response);
			}
		}



	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(request.getParameter("id")==null)
		{
			String marque = request.getParameter("marque");
			Integer ram= Integer.parseInt(request.getParameter("ram"));
			Integer idStagiaire= Integer.parseInt(request.getParameter("stagiaire.id"));
			Stagiaire stagiaire = daoStagiaire.findById(idStagiaire);

			Ordinateur ordinateur  = new Ordinateur(marque,ram,stagiaire);
			daoOrdinateur.save(ordinateur);

			response.sendRedirect("ordinateur");
		}
		else
		{
			Integer id= Integer.parseInt(request.getParameter("id"));
			String marque = request.getParameter("marque");
			Integer ram= Integer.parseInt(request.getParameter("ram"));
			Integer idStagiaire= Integer.parseInt(request.getParameter("stagiaire.id"));
			Stagiaire stagiaire = daoStagiaire.findById(idStagiaire);

			Ordinateur ordinateur  = new Ordinateur(id,marque,ram,stagiaire);
			daoOrdinateur.save(ordinateur);

			response.sendRedirect("ordinateur");
		}

	}

}
