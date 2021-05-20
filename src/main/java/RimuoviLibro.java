

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
 * Servlet implementation class RimuoviLibro
 */
@WebServlet("/RimuoviLibro")
public class RimuoviLibro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RimuoviLibro() {
        super();
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

		response.getWriter().append("Libro aggiunto");
		
		Libro libro = new Libro();

		int id = Integer.parseInt(request.getParameter("idLibro"));
		libro.setId(id);
	
				
		LibroDAO libroDAO = new LibroDAOImpl() ;
		
		try {
			libroDAO.deleteLibro(libro);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}


}
// if (idString )\