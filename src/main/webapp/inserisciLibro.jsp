<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp" >
<jsp:param value="" name=""/>
</jsp:include>
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
					<button type="submit" class="btn btn-success btn-md" name="azione">Aggiungi</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>