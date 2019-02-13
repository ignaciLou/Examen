package es.salesianos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.salesianos.model.DirectorActorFilm;
import es.salesianos.model.FilmActor;
import es.salesianos.repository.FilmActorRepository;

@Service
public class FilmActorService {
	
	@Autowired
	FilmActorRepository filmActorRepository;

	public static DirectorActorFilm filterAllFilmActor(String role) {
		return filmActorRepository.filterAllFilmActor(role);
	}
	
	public void insert(FilmActor filmActor) {
		filmActorRepository.insert(filmActor);
	}
	
}
