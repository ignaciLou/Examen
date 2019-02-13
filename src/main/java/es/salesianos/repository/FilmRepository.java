package es.salesianos.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import es.salesianos.connection.AbstractConnection;
import es.salesianos.connection.H2Connection;
import es.salesianos.model.Film;

@Repository
public class FilmRepository {

	private static final String jdbcUrl = "jdbc:h2:file:./src/main/resources/test";
	AbstractConnection manager = new H2Connection();
	private static final Logger log = LogManager.getLogger(ActorRepository.class);
	
	public void insert(Film film) {
		Connection connect = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connect.prepareStatement("INSERT INTO FILM (tittle)" + "VALUES (?)");
			preparedStatement.setString(1, film.getTitle());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			log.error(e);
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(connect);
		}
	}
	
	public void delete(Film film) {
		Connection connect = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connect.prepareStatement("DELETE FROM FILM WHERE cod = ?");
			preparedStatement.setInt(1, film.getCod());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			log.error(e);
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(connect);
		}

	}
	
	public List<Film> selectAllFilm() {
		Connection connect = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		List<Film> filmArrayList = new ArrayList<Film>();
		try {
			preparedStatement = connect.prepareStatement("SELECT * FROM FILM");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Film filmFromDataBase = new Film();
				filmFromDataBase.setCod(resultSet.getInt(1));
				filmFromDataBase.setCodDirector(resultSet.getInt(2));
				filmFromDataBase.setTitle(resultSet.getString(3));
				filmArrayList.add(filmFromDataBase);
			}
		} catch (SQLException e) {
			log.error(e);
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(connect);
		}
		return filmArrayList;
	}
}
