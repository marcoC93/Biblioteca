import java.sql.SQLException;

import Model.Libro;
import databaseconnection.LibroDAO;
import databaseconnection.LibroDAOImpl;



//import esempio.LibroDAO;

public class Main {

	public static void main(String[] args) {
		LibroDAO libroDAO =  new LibroDAOImpl();
		
		// inserire uno o pi� libro
		Libro libro = new Libro();
		libro.setTitle("Nome della rosa");
		libro.setAuthor("Umberto Eco");
		libro.setGenre("Romanzo");
		libro.setIsbn(12348778);
		
		
		try {
			libroDAO.insertLibro(libro);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// aggiornare le informazioni di un libro
		// calcellare un libro
		// stampare a video tutti i libri
		// stampare a video un specifico libro
		System.out.println("Codice funzionante"); 
		}

}
