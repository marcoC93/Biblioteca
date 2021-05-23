package databaseconnection;

import java.sql.SQLException;
import java.util.List;

import Login;

public interface UtenteDAO {
	public  boolean insertUtente(Login utente) throws SQLException ;	// CREATE
	public Login getUtente(int id) throws SQLException; 						// READ
	public Login getUtenteByISBN(int ISBN) throws SQLException;
	public List<Login> getUtente(String title) throws SQLException;					// READ
	public List<Login> getUtente(String title, String author) throws SQLException; 	// READ
	public List<Login> getAllUtenti() throws SQLException;					// READ
	
	public boolean updateUtente(Login utente) throws SQLException;				// UPDATE
	public boolean deleteUtente(Login utente) throws SQLException;				// DELETE
}
