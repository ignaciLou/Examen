package es.salesianos.service;

import java.util.List;

import es.salesianos.model.Director;
import es.salesianos.repository.DirectorRepository;

public class DirectorService {
	
	DirectorRepository directorRepository = new DirectorRepository();
	public List<Director> selectAllDirector() {
		return directorRepository.selectAllDirector();
	}
	
	public void insert(Director director) {
		directorRepository.insert(director);
	}
	
	public void delete(String codString) {
		Director director = new Director();
		int cod = Integer.parseInt(codString);
		director.setCod(cod);
		directorRepository.delete(director);
	}
	
	public Director filterAllDirector(String nameDirector) {
		return directorRepository.filterAllDirector(nameDirector);
	}
}
