package es.salesianos.model.assembler;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.Film;

public class FilmAssembler {
	
	public static Film assembleFilmFrom(HttpServletRequest request) {
		Film film = new Film();
		String codDirector = request.getParameter("codDirector");
		if(codDirector != null) {
			film.setCodDirector(Integer.parseInt(codDirector));
		}
		String title = request.getParameter("title");
		film.setTitle(title);
		return film;
	}

}
