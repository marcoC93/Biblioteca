<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
	integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l"
	crossorigin="anonymous">
</head>
<body>
	<div class="container" > 
		<div class="row justify-conten	t-center" >
			<div class="col-6">
				<form action="Utente" method="post">
					<div class="mb-3">
						<label for="exampleFormControlInput1" class="form-label">Nome utente</label>
						<input type="text" class="form-control" 
						id="exampleFormControlInput1" name="nome">
					<div class="mb-3">
						<label for="exampleFormControlInput1" class="form-label">Password</label>
						<input type="password" class="form-control"
						id="exampleFormControlInput1" name="password">
					</div>	
					</div>
					<div class="mb-3">
						<label for="exampleFormControlInput1" class="form-label">Invia</label>
					 	<input type="submit" class="form-control"
						id="exampleFormControlInput1" placeholder=""
						name="">
				</div>
				</form>	
					
			</div>
		</div>
	</div>
	
</body>
</html>