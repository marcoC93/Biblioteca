


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Utente
 */
@WebServlet("/Utente")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor. 
	 */
	public Login() {
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
		//		doGet(request, response);

		PrintWriter out = response.getWriter();

		String name =  request.getParameter("nome");
		if (name != null && !name.equals("")) {
			out.println(name);
		}
		else {
			out.println("Username non corretta");
		}



		String password = request.getParameter("password");
		if (password != null && !password.equals("")) {

			out.println(password);

		}
		else {
			out.println("password non corretta");
		}


		//			

		//			

		if(name.equals("maria" ) && password.equals("maria")) {

			response.sendRedirect("dashboard.jsp") ;

		}
		else {

			response.sendRedirect("RicercaLibro.jsp");

		}
	}




}


