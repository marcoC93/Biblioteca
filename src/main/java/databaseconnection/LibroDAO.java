package databaseconnection;

import java.sql.SQLException;
import java.util.List;

import Model.Libro;

public interface LibroDAO {
	public  boolean insertLibro(Libro Libro) throws SQLException ;	// CREATE
	public Libro getLibro(int id) throws SQLException; 						// READ
	public Libro getLibroByISBN(int ISBN) throws SQLException;
	public List<Libro> getLibro(String title) throws SQLException;					// READ
	public List<Libro> getLibro(String title, String author) throws SQLException; 	// READ
	public List<Libro> getAllLibri() throws SQLException;					// READ
	public boolean updateLibro(Libro Libro) throws SQLException;				// UPDATE
	public boolean deleteLibro(Libro Libro) throws SQLException;				// DELETE
}
