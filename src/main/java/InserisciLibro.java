

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Libro;

import databaseconnection.LibroDAO;
import databaseconnection.LibroDAOImpl;
/**
 * Servlet implementation class InserisciLibro
 */
@WebServlet("/InserisciLibro")
public class InserisciLibro extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public InserisciLibro() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		Libro libro = new Libro();
		libro.setTitle(request.getParameter("title"));
		libro.setAuthor(request.getParameter("author"));
		libro.setGenre(request.getParameter("genre"));
		libro.setIsbn(Integer.parseInt(request.getParameter("isbn")));
		
		LibroDAO libroDAO = new LibroDAOImpl() ;
		
		
		
		try {
			libroDAO.insertLibro(libro);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		response.getWriter().append("Libro aggiunto");
		response.getWriter().append(libro.getTitle()); 
		response.getWriter().append(libro.getAuthor());
		response.getWriter().append(libro.getGenre());
		response.getWriter().append(Integer.toString(libro.getIsbn()));
		
		}	
}
