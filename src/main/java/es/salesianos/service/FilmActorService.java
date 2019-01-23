package es.salesianos.service;

import es.salesianos.model.DirectorActorFilm;
import es.salesianos.model.FilmActor;
import es.salesianos.repository.FilmActorRepository;

public class FilmActorService {
	static FilmActorRepository filmActorRepository =  new FilmActorRepository();

	public static DirectorActorFilm filterAllFilmActor(String role) {
		return filmActorRepository.filterAllFilmActor(role);
	}
	
	public void insert(FilmActor filmActor) {
		filmActorRepository.insert(filmActor);
	}
	
}
