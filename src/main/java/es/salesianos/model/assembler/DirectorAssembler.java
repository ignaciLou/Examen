package es.salesianos.model.assembler;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.Director;

public class DirectorAssembler {

	public static Director assembleDirectorFrom(HttpServletRequest request) {
		Director director = new Director();
		String codDirector = request.getParameter("cod");
		if(codDirector != null) {
			director.setCod(Integer.parseInt(codDirector));
		}
		String name = request.getParameter("name");
		director.setName(name);
		return director;
	}

}