package databaseconnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import Model.Libro;




/**
 * AbstractDAO.java
 * This DAO class provides CRUD database operations for the table Libro
 * in the database.
 * @author www.codejava.net
 *
 */
public class LibroDAOImpl implements LibroDAO {
	public boolean insertLibro(Libro Libro) throws SQLException {
		String sql = "INSERT INTO libro (title,author,genre,isbn) VALUES (?, ?, ?, ?)";
		Connection jdbcConnection = DatabaseConnection.connect();

		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setString(1, Libro.getTitle());
		statement.setString(2, Libro.getAuthor());
		statement.setString(3, Libro.getGenre());
		statement.setInt(4, Libro.getIsbn());

		
		boolean rowInserted = statement.executeUpdate() > 0;
		statement.close();
		DatabaseConnection.disconnect();
		return rowInserted;
	}

	public List<Libro> getAllLibri() throws SQLException {
		List<Libro> listLibro = new ArrayList<>();

		String sql = "SELECT * FROM Libro";

		Connection jdbcConnection = DatabaseConnection.connect();

		Statement statement = jdbcConnection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);

		while (resultSet.next()) {
			int id = resultSet.getInt("id");
			String title = resultSet.getString("title");
			String author = resultSet.getString("author");
			String genre = resultSet.getString("genre");
			int isbn = resultSet.getInt("isbn");
			
			Libro Libro = new Libro();
			Libro.setId(id);
			Libro.setTitle(title);
			Libro.setAuthor(author);
			Libro.setGenre(genre);
			Libro.setIsbn(isbn);
//			Libro Libro = new Libro(id, title, author, price);
			listLibro.add(Libro);
		}

		resultSet.close();
		statement.close();

		DatabaseConnection.disconnect();

		return listLibro;
	}

	public boolean deleteLibro(Libro Libro) throws SQLException {
		String sql = "DELETE FROM Libro where id = ?";

		Connection jdbcConnection = DatabaseConnection.connect();

		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setInt(1, Libro.getId());

		boolean rowDeleted = statement.executeUpdate() > 0;
		statement.close();
		DatabaseConnection.disconnect();
		return rowDeleted;     
	}

	public boolean updateLibro(Libro Libro) throws SQLException {
		String sql = "UPDATE Libro SET title = ?, author = ?";
		sql += " WHERE Libro_id = ?";
		Connection jdbcConnection = DatabaseConnection.connect();

		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setString(1, Libro.getTitle());
		statement.setString(2, Libro.getAuthor());

		statement.setInt(3, Libro.getId());

		boolean rowUpdated = statement.executeUpdate() > 0;
		statement.close();
		DatabaseConnection.disconnect();
		return rowUpdated;     
	}

	public Libro getLibro(int id) throws SQLException {
		Libro libro = null;
		String sql = "SELECT * FROM Libro WHERE Libro_id = ?";

		Connection jdbcConnection = DatabaseConnection.connect();

		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setInt(1, id);

		ResultSet resultSet = statement.executeQuery();

		if (resultSet.next()) {
			String title = resultSet.getString("title");
			String author = resultSet.getString("author");
			String genre = resultSet.getString("genre");
			int isbn = resultSet.getInt("isbn");

			libro = new Libro(id, title, author, genre , isbn );
		}

		resultSet.close();
		statement.close();
		DatabaseConnection.disconnect();
		return libro;
	}

	@Override
	public List<Libro> getLibro(String title) throws SQLException {
		String sql = "SELECT * FROM Libro WHERE title = ?";
		List<Libro> list = new ArrayList<Libro>();
		
		Connection jdbcConnection = DatabaseConnection.connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setString(1, title);
		
//		Statement stat = jdbcConnection.createStatement();
//		ResultSet resultSet = stat.executeQuery(sql);
		
		ResultSet resultSet = statement.executeQuery();
		while(resultSet.next()) {
			Libro Libro = new Libro();
			Libro.setId(resultSet.getInt("id"));
			Libro.setTitle(resultSet.getString("title"));
//			Libro.setPrice(resultSet.getFloat("price"));
			
			list.add(Libro);
		}
		
		
		resultSet.close();
		statement.close();
		DatabaseConnection.disconnect();
		
		return list;
	}

	@Override
	public List<Libro> getLibro(String title, String author) throws SQLException {
		String sql = "SELECT * FROM Libro WHERE title = ? AND author = ?";
		List<Libro> list = new ArrayList<Libro>();
		
		Connection jdbcConnection = DatabaseConnection.connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setString(1, title);
		statement.setString(2, author);
		
//		Statement stat = jdbcConnection.createStatement();
//		ResultSet resultSet = stat.executeQuery(sql);
		
		ResultSet resultSet = statement.executeQuery();
		while(resultSet.next()) {
			Libro Libro = new Libro();
			Libro.setId(resultSet.getInt("id"));
			Libro.setTitle(resultSet.getString("title"));
//			Libro.setPrice(resultSet.getFloat("price"));
			
			list.add(Libro);
		}
		
		
		resultSet.close();
		statement.close();
		DatabaseConnection.disconnect();
		
		return list;
	}

	@Override
	public Libro getLibroByISBN(int ISBN) throws SQLException {
		Libro Libro = new Libro();
		String sql = "SELECT * FROM Libro WHERE isbn = ?";

		Connection jdbcConnection = DatabaseConnection.connect();

		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setInt(1, ISBN);

		ResultSet resultSet = statement.executeQuery();

		if (resultSet.next()) {
			Libro.setTitle(resultSet.getString("title"));
		}

		resultSet.close();
		statement.close();
		DatabaseConnection.disconnect();
		return Libro;
	}
//	@Override
//	public List<Libro> getLibro(String title, String author, String genre, int ISBN) trows SQLException ;
//		List<Libro> listlibro = new ArrayList<Libro>;
//		String sql = "SELECT * FROM Libro WHERE 1=1 AND title = ? " ;
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