<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Home</title>
     <link href="css/bootstrap.min.css" rel="stylesheet">
  </head>
  <body>
  <nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="home.jsp">Proxima Informatica</a>
</nav>	
	<div class="container-fluid">	
   <form action="ImpiegatoServlet">
   <% String id = (String)request.getParameter("id"); %>
	<% String nome = (String)request.getParameter("nome"); %>
	<% String cognome = (String)request.getParameter("cognome"); %>
	<% String codfisc = (String)request.getParameter("codfisc"); %>	
	
		ID:<br> <input type="text" name= "id" value="<%=id %>"> <br>
		Nome:<br> <input type="text" name="nome" value="<%=nome %>"><br>
		Cognome:<br> <input type="text" name="cognome" value="<%=cognome %>"> <br>
		Codice Fiscale <br> <input type="text" name="codfisc" value="<%=codfisc %>"> <br>	
		<input type="hidden" name="funzione" value="aggiorna">
		<br> <input	type="submit" value="Modifica">
		
</form>		
		</div>
    
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    
    <script src="js/bootstrap.min.js"></script>
  </body>
</html>

