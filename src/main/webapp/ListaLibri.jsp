<%@ page import="java.util.List"  %>
<%@ page import="Model.Libro" %>
<%@ page import="databaseconnection.LibroDAO" %>
<%@ page import="databaseconnection.LibroDAOImpl" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista Libri</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-10">
				<h1>Lista dei libri</h1>
				<table class="table table-dark table-hover justify-content-center">
					<thead>
						<tr>
							<th scope="col">Titolo</th>
							<th scope="col">Autore</th>
							<th scope="col">Genere</th>
							<th scope="col">Isbn</th>
							<th scope="col">Modifica</th>
							<th scope="col">Cancella</th>
						</tr>
					</thead>
					<tbody>
						<% LibroDAO libroDAO = new LibroDAOImpl(); %>
						<% List<Libro> listLibro = libroDAO.getAllLibri() ; 
						if(listLibro != null) {
						for(int i = 0 ; i < listLibro.size(); i++) {
						Libro libro = (Libro) listLibro.get(i);
						
						%>
						<tr>
							<td scope="row">
								<%=libro.getTitle()%>
							</td>
							<td>
								<%=libro.getAuthor()%>
							</td>
							<td>
								<%=libro.getGenre()%>
							</td>
							<td>
								<%=libro.getIsbn()%>
							</td>
							<td>
								<form action="ModificaLibro" method="post">
									<input type="hidden" name="id" value="<%= libro.getId() %>">
									<button type="submit" class="btn btn-black">Modifica</button>
								</form>	
							</td>
							<td>
								<form action="RimuoviLibro" method="post">		
									<button type="submit" class="btn btn-danger">Delete</button>
								</form>
							</td>
							<%
						}
						}
						else {
							//pageContext.forward("RicercaLibro");
							%>
							<jsp:forward page="RicercaLibro" />
							<%
						}
							%>

						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>