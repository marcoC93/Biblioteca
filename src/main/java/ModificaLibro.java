

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Libro;
import databaseconnection.LibroDAO;
import databaseconnection.LibroDAOImpl;
/**
 * Servlet implementation class ModificaLibro
 */
@WebServlet("/ModificaLibro")
public class ModificaLibro extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ModificaLibro() {
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

		Libro libro = new Libro();
		String idString = request.getParameter("id");

		int id = Integer.parseInt(idString);
		
		LibroDAO libroDAO = new LibroDAOImpl() ;
		response.getWriter().append(idString);
		response.getWriter().append(request.getParameter("title"));
		response.getWriter().append(request.getParameter("author")); 
		response.getWriter().append(request.getParameter("genre"));
		response.getWriter().append(request.getParameter("isbn"));

		libro.setTitle(request.getParameter("title"));
		libro.setAuthor(request.getParameter("author"));
		libro.setGenre(request.getParameter("genre"));
		libro.setIsbn(Integer.parseInt(request.getParameter("isbn")));
		libro.setId(id);
		
		try {
			libroDAO.updateLibro(libro);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}

	}
}	



//	
//}
//





// TODO Auto-generated method stub

//String idLibro = request.getParameter("id");
//int id = Integer.parseInt(idLibro);
//LibroDAO libroDAO = new LibroDAOImpl();
//try {
//	Libro libro = libroDAO.getLibro(id);
//	request.setAttribute("libro", libro);
//	RequestDispatcher requestDispatcher = request.getRequestDispatcher("ModificaLibro.jsp");
//	requestDispatcher.forward(request, response);
//}
//
//catch (SQLException e ) {
//
//	e.printStackTrace();
//	}
