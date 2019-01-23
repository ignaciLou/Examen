package es.salesianos.service;

import java.util.List;

import es.salesianos.model.Actor;
import es.salesianos.repository.ActorRepository;

public class ActorService {

	private ActorRepository actorRepository = new ActorRepository();
	public List<Actor> filterAllActor(int beginDate, int endDate) {
		return actorRepository.filterAllActor(beginDate, endDate);
	}
	
	public List<Actor> selectAllActor() {
		return actorRepository.selectAllActor();
	}
	
	public void insert(Actor actor) {
		actorRepository.insert(actor);
	}
	
	public void delete(String codString) {
		Actor actor = new Actor();
		int cod = Integer.parseInt(codString);
		actor.setCod(cod);
		actorRepository.delete(actor);
	}
}
