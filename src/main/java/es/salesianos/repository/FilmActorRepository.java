package es.salesianos.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import es.salesianos.connection.AbstractConnection;
import es.salesianos.connection.H2Connection;
import es.salesianos.model.DirectorActorFilm;
import es.salesianos.model.FilmActor;

@Repository
public class FilmActorRepository {
	private static final String jdbcUrl = "jdbc:h2:file:./src/main/resources/test";
	AbstractConnection manager = new H2Connection();
	private static final Logger log = LogManager.getLogger(ActorRepository.class);

	public void insert(FilmActor filmActor) {
		Connection connect = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connect.prepareStatement("INSERT INTO FILMACTOR (codActor, codFilm, cache, role)" + "VALUES (?, ?, ?, ?)");
			preparedStatement.setInt(1, filmActor.getCodActor());
			preparedStatement.setInt(2, filmActor.getCodFilm());
			preparedStatement.setInt(3, filmActor.getCache());
			preparedStatement.setString(4, filmActor.getRole());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			log.error(e);
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(connect);
		}
	}
	
	public DirectorActorFilm filterAllFilmActor(String role) {
		Connection connect = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		DirectorActorFilm film = null;
		try {
			preparedStatement = connect.prepareStatement("SELECT TITTLE, NAME, YEAROFBIRTHDATE" + 
					" FROM ((FILMACTOR" + 
					" INNER JOIN FILM ON FILM.COD = FILMACTOR.CODFILM)" + 
					" INNER JOIN ACTOR ON ACTOR.COD = FILMACTOR.CODACTOR)" + 
					" WHERE FILMACTOR.ROLE = (?)");
			preparedStatement.setString(4, role);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				DirectorActorFilm filmFromDataBase = new DirectorActorFilm();
				filmFromDataBase.setTitle(resultSet.getString(1));
				filmFromDataBase.setName(resultSet.getString(2));
				filmFromDataBase.setYear(resultSet.getInt(3));
				film = filmFromDataBase;
			}
		} catch (SQLException e) {
			log.error(e);
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(connect);
		}
		return film;
	}
}
