package es.salesianos.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.DirectorActorFilm;
import es.salesianos.service.FilmActorService;

public class SearchRoleServlet {

	private static final long serialVersionUID = 1L;
	private FilmActorService FilmActorservice = new FilmActorService();

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doAction(req, resp);
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doAction(req, resp);
	}

	private void doAction(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String role = req.getParameter("role");
		if (role != null) {
			DirectorActorFilm selectFilmActor = FilmActorService.filterAllFilmActor(role);
			req.setAttribute("selectFilmActor", selectFilmActor);
		}
		redirect(req, resp);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/searchRole.jsp");
		requestDispatcher.forward(req, resp);
	}
}
