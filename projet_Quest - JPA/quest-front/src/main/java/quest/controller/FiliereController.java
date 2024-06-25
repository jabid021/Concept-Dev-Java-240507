package quest.controller;

import java.io.IOException;
import java.time.LocalDate;
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
import quest.service.FiliereService;


@WebServlet("/filiere")
public class FiliereController extends HttpServlet {

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
			List<Filiere> filieres = filiereSrv.getAll();
			request.setAttribute("filieres", filieres);
			this.getServletContext().getRequestDispatcher("/WEB-INF/filieres.jsp").forward(request, response);
		}
		else
		{
			if(request.getParameter("delete") != null)
			{
				Integer id= Integer.parseInt(request.getParameter("id"));
				filiereSrv.deleteById(id);
				response.sendRedirect("filiere");
			}
			else
			{
				Integer id= Integer.parseInt(request.getParameter("id"));
				Filiere filiere = filiereSrv.getById(id);
				request.setAttribute("filiere", filiere);
				this.getServletContext().getRequestDispatcher("/WEB-INF/updateFiliere.jsp").forward(request, response);
			}
		}



	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(request.getParameter("id")==null)
		{
			String libelle = request.getParameter("libelle");
			String debut = request.getParameter("debut");
			String fin = request.getParameter("fin");

			Filiere filiere  = new Filiere(libelle,LocalDate.parse(debut),LocalDate.parse(fin));
			filiereSrv.insert(filiere);

			response.sendRedirect("filiere");
		}
		else
		{
			Integer id= Integer.parseInt(request.getParameter("id"));
			Integer version= Integer.parseInt(request.getParameter("version"));
			String libelle = request.getParameter("libelle");
			LocalDate debut = LocalDate.parse(request.getParameter("debut"));
			String fin = request.getParameter("fin");

			Filiere filiere  = new Filiere(id,libelle,debut,LocalDate.parse(fin));
			filiere.setVersion(version);

			try{
				filiereSrv.update(filiere);
			}
			catch(Exception e) 
			{
				filiere = filiereSrv.getById(id);
				request.setAttribute("filiere", filiere);
				request.setAttribute("error", "Filiere deja update ?! Verifier les nouvelles données avant modif");
				this.getServletContext().getRequestDispatcher("/WEB-INF/updateFiliere.jsp").forward(request, response);
			}
		}
		response.sendRedirect("filiere");
	}

}


