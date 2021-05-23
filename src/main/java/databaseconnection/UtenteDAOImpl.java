package databaseconnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Login;




/**
 * AbstractDAO.java
 * This DAO class provides CRUD database operations for the table Utente
 * in the database.
 * @author www.codejava.net
 *
 */
public class UtenteDAOImpl implements UtenteDAO {
	public boolean insertUtente(Login utente) throws SQLException {
		String sql = "INSERT INTO libro (title,author,genre,isbn) VALUES (?, ?, ?, ?)";
		Connection jdbcConnection = DatabaseConnection.connect();

		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setString(1, Login.getTitle());
		statement.setString(2, Login.getAuthor());
		statement.setString(3, Login.getGenre());
		statement.setInt(4, Login.getIsbn());

		
		boolean rowInserted = statement.executeUpdate() > 0;
		statement.close();
		DatabaseConnection.disconnect();
		return rowInserted;
	}

	public List<Login> getAllLibri() throws SQLException {
		List<Login> listUtente = new ArrayList<>();

		String sql = "SELECT * FROM Utente";

		Connection jdbcConnection = DatabaseConnection.connect();

		Statement statement = jdbcConnection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);

		while (resultSet.next()) {
			int id = resultSet.getInt("id");
			String title = resultSet.getString("title");
			String author = resultSet.getString("author");
			String genre = resultSet.getString("genre");
			int isbn = resultSet.getInt("isbn");
			
			Login Utente = new Login();
			Utente.setId(id);
			Utente.setTitle(title);
			Utente.setAuthor(author);
			Utente.setGenre(genre);
			Utente.setIsbn(isbn);
//			Utente Utente = new Utente(id, title, author, price);
			listUtente.add(Utente);
		}

		resultSet.close();
		statement.close();

		DatabaseConnection.disconnect();

		return listUtente;
	}

	public boolean deleteUtente(Login Utente) throws SQLException {
		String sql = "DELETE FROM Utente where id = ?";

		Connection jdbcConnection = DatabaseConnection.connect();

		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setInt(1, Utente.getId());

		boolean rowDeleted = statement.executeUpdate() > 0;
		statement.close();
		DatabaseConnection.disconnect();
		return rowDeleted;     
	}

	public boolean updateUtente(Login libro) throws SQLException {
		String sql = "UPDATE Utente SET title = ?, author = ?,genre = ?, isbn = ?" ;
		sql += " WHERE id = ?";
		Connection jdbcConnection = DatabaseConnection.connect();

		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setString(1, libro.getTitle());
		statement.setString(2, libro.getAuthor());
		statement.setString(3, libro.getGenre());
		statement.setInt(4, libro.getIsbn());
		statement.setInt(5, libro.getId());

		boolean rowUpdated = statement.executeUpdate() > 0;
		statement.close();
		DatabaseConnection.disconnect();
		return rowUpdated;     
	}

	public Login getUtente(int id) throws SQLException {
		Login libro = null;
		String sql = "SELECT * FROM Utente WHERE id = ?";

		Connection jdbcConnection = DatabaseConnection.connect();

		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setInt(1, id);

		ResultSet resultSet = statement.executeQuery();

		if (resultSet.next()) {
			String title = resultSet.getString("title");
			String author = resultSet.getString("author");
			String genre = resultSet.getString("genre");
			int isbn = resultSet.getInt("isbn");

			libro = new Login(id, title, author, genre , isbn );
		}

		resultSet.close();
		statement.close();
		DatabaseConnection.disconnect();
		return libro;
	}

	@Override
	public List<Login> getUtente(String title) throws SQLException {
		String sql = "SELECT * FROM Utente WHERE title = ?";
		List<Login> list = new ArrayList<Login>();
		
		Connection jdbcConnection = DatabaseConnection.connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setString(1, title);
		
//		Statement stat = jdbcConnection.createStatement();
//		ResultSet resultSet = stat.executeQuery(sql);
		
		ResultSet resultSet = statement.executeQuery();
		while(resultSet.next()) {
			Login Utente = new Login();
			Utente.setId(resultSet.getInt("id"));
			Utente.setTitle(resultSet.getString("title"));
//			Utente.setPrice(resultSet.getFloat("price"));
			
			list.add(Utente);
		}
		
		
		resultSet.close();
		statement.close();
		DatabaseConnection.disconnect();
		
		return list;
	}

	@Override
	public List<Login> getUtente(String title, String author) throws SQLException {
		String sql = "SELECT * FROM Utente WHERE title = ? AND author = ?";
		List<Login> list = new ArrayList<Login>();
		
		Connection jdbcConnection = DatabaseConnection.connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setString(1, title);
		statement.setString(2, author);
		
//		Statement stat = jdbcConnection.createStatement();
//		ResultSet resultSet = stat.executeQuery(sql);
		
		ResultSet resultSet = statement.executeQuery();
		while(resultSet.next()) {
			Login Utente = new Login();
			Utente.setId(resultSet.getInt("id"));
			Utente.setTitle(resultSet.getString("title"));
//			Utente.setPrice(resultSet.getFloat("price"));
			
			list.add(Utente);
		}
		
		
		resultSet.close();
		statement.close();
		DatabaseConnection.disconnect();
		
		return list;
	}

	@Override
	public Login getUtenteByISBN(int ISBN) throws SQLException {
		Login Utente = new Login();
		String sql = "SELECT * FROM Utente WHERE isbn = ?";

		Connection jdbcConnection = DatabaseConnection.connect();

		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setInt(1, ISBN);

		ResultSet resultSet = statement.executeQuery();

		if (resultSet.next()) {
			Utente.setTitle(resultSet.getString("title"));
		}

		resultSet.close();
		statement.close();
		DatabaseConnection.disconnect();
		return Utente;
	}
//	@Override
//	public List<Utente> getUtente(String title, String author, String genre, int ISBN) trows SQLException ;
//		List<Utente> listlibro = new ArrayList<Utente>;
//		String sql = "SELECT * FROM Utente WHERE 1=1 AND title = ? " ;
//		if(title != null && !title.equals("")) {
//			sql =sql + "AND title = ?" ;
//		}
//		if(author != null && !author.equals("")) {
//			sql =sql + "AND author = ?" ;
//		}
//		if(genre != null && !author.equals("")) {
//			sql =sql + "AND genre = ?" ;
//		}
//		if(isbnString != null && !isbnString.equals("")) {
//			int isbn = Integer.parseInt(isbnString);
//			if(isbn > 0 ) {
//				sql =sql + "AND isbn = ?" ;
//			}
//			
//		}
//		Connection jdbcConnection = DatabaseConnection.connect();
//		Prepared
//}

}	