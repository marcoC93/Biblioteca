<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
	integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l"
	crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="row justify-content-center">
			<form class="col-6" action="InserisciLibro" method="post">
				<h1>Ciao benvenuto registra il tuo libro</h1>
				<div class="mb-3">
					<label for="exampleFormControlInput1" class="form-label">Titolo</label>
					<input type="text" class="form-control"
						id="exampleFormControlInput1" name="title">
				</div>
				<div class="mb-3">
					<label for="exampleFormControlInput1" class="form-label">Autore</label>
					<input type="text" class="form-control"
						id="exampleFormControlInput1" name="author">
				</div>
				<div class="mb-3">
					<label for="exampleFormControlInput1" class="form-label">Genere</label>
					<select id="exampleFormControlInput1" name="genre">
						<option value="Thriller" >Thriller</option>
						<option value="Romantico">Romantico</option>
						<option value="Avventura">Avventura</option>
						<option value="Horror">Horror</option>
					</select>
				</div>

				<div class="mb-3">
					<label for="exampleFormControlInput1" class="form-label">Isbn</label>
					<input type="number" class="form-control" name="isbn"
						id="exampleFormControlInput1">
				</div>

				<div class="mb-3">
					<button type="submit" class="btn btn-primary btn-md" name="azione">Registrati</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>