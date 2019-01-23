package es.salesianos.service;

import java.util.List;

import es.salesianos.model.Film;
import es.salesianos.repository.FilmRepository;

public class FilmService {
	FilmRepository filmRepository = new FilmRepository();
	
	public List<Film> selectAllFilm() {
		return filmRepository.selectAllFilm();
	}
	
	public void insert(Film film) {
		filmRepository.insert(film);
	}
	
	public void delete(String codString) {
		Film film = new Film();
		int cod = Integer.parseInt(codString);
		film.setCod(cod);
		filmRepository.delete(film);
	}
	
}
