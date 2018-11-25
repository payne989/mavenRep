<%@ page import="modelJpa.Impiegato"%>
<%@ page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Risultato Impiegato singolo</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="home.jsp">Proxima Informatica</a>
	</nav>
	<div class="container-fluid">
		<form action="ImpiegatoServlet" method="get">

			<%
				Impiegato imp = (Impiegato) request.getAttribute("impiegato");
			%>
			<b>Id: </b><input type="text" name="id" value="<%=imp.getId()%>"readonly> <br> <br> 
			<b>Codice Fiscale: </b><input type="text" name="codfisc" value="<%=imp.getCodFisc()%>"> <br><br> 
			<b>Nome: </b><input type="text" name="nome"value="<%=imp.getNome()%>"> <br> <br> 
			<b>Cognome:</b><input type="text" name="cognome" value="<%=imp.getCognome()%>"><br> <br> 
			
			<input type="hidden" name="funzione" value="aggiorna"> 
			<input type="submit" value="Aggiorna">
			
			<input type="hidden" name="funzione" value="cancella"> 
			<input type="submit" value="Cancella"> <br>

		</form>
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