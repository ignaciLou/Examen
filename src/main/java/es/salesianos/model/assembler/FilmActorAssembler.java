package es.salesianos.model.assembler;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.FilmActor;

public class FilmActorAssembler {
	public static FilmActor assembleFilmActorFrom(HttpServletRequest request) {
		FilmActor filmActor = new FilmActor();
		String codFilm = request.getParameter("codFilm");
		String codActor = request.getParameter("codActor");
		String cache = request.getParameter("cache");
		String role = request.getParameter("role");
		filmActor.setCodFilm(Integer.parseInt(codFilm));
		filmActor.setCodActor(Integer.parseInt(codActor));
		filmActor.setCache(Integer.parseInt(cache));
		filmActor.setRole(role);
		
		return filmActor;
	}
}
