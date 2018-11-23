<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>CercaRuolo</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="home.jsp">Proxima Informatica</a>
	</nav>

	<div class="container-fluid">
		<h1>
			<font>Ricerca Ruolo</font>
		</h1>
	</div>
	<br>

	<div class="container-fluid">
		<form action="RuoloServlet" method="get">
			<font>Ricerca tramite ID:</font><br> <input type="text"
				name="id"> <br> <input type="hidden" name="funzione"
				value="cerca"> <input type="submit" value="Cerca"><br>
		</form>

		<br>
		<form action="RuoloServlet" method="get">
			<font>Ricerca tramite Nome:</font><br> <input
				type="text" name="nome"> <br> <input
				type="hidden" name="funzione" value="cercanome"> <input
				type="submit" value="Cerca"><br>
		</form>

		<br>
		
	</div>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
		integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
		integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
		crossorigin="anonymous"></script>

	<script src="js/bootstrap.min.js"></script>
</body>
</html>