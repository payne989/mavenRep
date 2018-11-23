<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Anagrafica</title>
     <link href="css/bootstrap.min.css" rel="stylesheet">
  </head>
  <body>	
  <nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="home.jsp">Proxima Informatica</a>
</nav>	
    <form action="ImpiegatoServlet" method="get">

		<h1>Sezione Anagrafica Proxima Academy</h1> <br>
		<br>
	<div class="container-fluid">	
	<a class="btn btn-dark"	href="inserisciImpiegato.jsp">Inserisci Impiegato</a>
	<a class="btn btn-dark"	href="cercaImpiegato.jsp">Cerca Impiegato</a>
	<a class="btn btn-dark"	href="ImpiegatoServlet?funzione=cercaall">Lista Impiegati</a> 
	</div>
	
	
	<br> <br>
	<div class="container-fluid">
	<a class="btn btn-dark"	href="inserisciRuolo.jsp">Inserisci Ruolo</a>
	<a class="btn btn-dark"	href="cercaRuolo.jsp">Cerca Ruolo</a>
	<a class="btn btn-dark"	href="listaRuoli.jsp">Lista Ruoli</a> <br>
	</div>	

	</form>

    
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    
    <script src="js/bootstrap.min.js"></script>
  </body>
</html>