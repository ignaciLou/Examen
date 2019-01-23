package es.salesianos.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;

import es.salesianos.model.FilmActor;
import es.salesianos.model.assembler.FilmActorAssembler;
import es.salesianos.service.FilmActorService;

public class FillFIlmActorServlet {

	private static final long serialVersionUID = 1L;
	private FilmActorService FilmActorService = new FilmActorService();

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		FilmActor filmActor = FilmActorAssembler.assembleFilmActorFrom(req);
		FilmActorService.insert(filmActor);
		doAction(req, resp);
	}
 
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String codFilm = req.getParameter("codFilm");
		String codActor = req.getParameter("codActor");
		req.setAttribute("codFilm", codFilm);
		req.setAttribute("codActor", codActor);
		doAction(req, resp);
	}

	private void doAction(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		redirect(req, resp);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/fillFilmActor.jsp");
		requestDispatcher.forward(req, resp);
	}
}
