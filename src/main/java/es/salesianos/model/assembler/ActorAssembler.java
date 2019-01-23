package es.salesianos.model.assembler;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.Actor;

public class ActorAssembler {

	public static Actor assembleActorFrom(HttpServletRequest request) {
		Actor actor = new Actor();
		String year = request.getParameter("year");
		if(year != null) {
			actor.setYear(Integer.parseInt(year));
		}
		String name = request.getParameter("name");
		actor.setName(name);
		return actor;
	}

}
