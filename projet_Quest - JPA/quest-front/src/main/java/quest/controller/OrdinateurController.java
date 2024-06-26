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

import quest.model.Ordinateur;
import quest.model.Stagiaire;
import quest.service.OrdinateurService;
import quest.service.StagiaireService;


@WebServlet("/ordinateur")
public class OrdinateurController extends HttpServlet {

	@Autowired
	OrdinateurService ordinateurSrv;

	@Autowired
	StagiaireService stagiaireSrv;

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(request.getParameter("id")==null)
		{
			List<Ordinateur> ordinateurs = ordinateurSrv.getAll();
			List<Stagiaire> stagiaires = stagiaireSrv.getAllDisponibles();
			request.setAttribute("ordinateurs", ordinateurs);
			request.setAttribute("stagiaires", stagiaires);
			this.getServletContext().getRequestDispatcher("/WEB-INF/ordinateurs.jsp").forward(request, response);
		}
		else
		{
			if(request.getParameter("delete") != null)
			{
				Integer id= Integer.parseInt(request.getParameter("id"));
				ordinateurSrv.deleteById(id);
				response.sendRedirect("ordinateur");
			}
			else
			{
				Integer id= Integer.parseInt(request.getParameter("id"));
				Ordinateur ordinateur = ordinateurSrv.getById(id);
				List<Stagiaire> stagiaires = stagiaireSrv.getAllDisponibles();
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
			Stagiaire stagiaire = stagiaireSrv.getById(idStagiaire);

			Ordinateur ordinateur  = new Ordinateur(marque,ram,stagiaire);
			ordinateurSrv.insert(ordinateur);

			response.sendRedirect("ordinateur");
		}
		else
		{
			Integer id= Integer.parseInt(request.getParameter("id"));
			String marque = request.getParameter("marque");
			Integer ram= Integer.parseInt(request.getParameter("ram"));
			Integer idStagiaire= Integer.parseInt(request.getParameter("stagiaire.id"));
			Stagiaire stagiaire = stagiaireSrv.getById(idStagiaire);

			Ordinateur ordinateur  = new Ordinateur(id,marque,ram,stagiaire);
			ordinateurSrv.update(ordinateur);

			response.sendRedirect("ordinateur");
		}

	}

}
