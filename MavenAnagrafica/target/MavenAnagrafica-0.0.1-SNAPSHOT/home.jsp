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
    <form action="ImpiegatoServlet" method="get">

		<h1>App Aziendale Proxima Academy</h1> <br>
		<div class="card-deck mb-3 text-center">
        <div class="card mb-4 shadow-sm">
          <div class="card-header">
            <h4 class="my-0 font-weight-normal">Anagrafica</h4>
          </div>
          <div class="card-body">
            <ul class="list-unstyled mt-3 mb-4">
              <li>Operazioni Anagrafiche</li>
              <li>Operazioni Impiegato</li>
              <li>Operazioni Ruolo</li>
            </ul>
            <a type="button" class="btn btn-dark btn-lg" href="anagrafica.jsp" >Entra</a>
          </div>
        </div>
        <div class="card mb-4 shadow-sm">
          <div class="card-header">
            <h4 class="my-0 font-weight-normal">E-Wallet</h4>
          </div>
          <div class="card-body">
            <ul class="list-unstyled mt-3 mb-4">
              <li>Operazioni di Online Banking</li>
              <li>Bonifici</li>
              <li>Lista Movimenti</li>
            </ul>
            <a type="button" class="btn btn-dark btn-lg" href="ewallet.jsp" >Entra</a>
          </div>
        </div>
        <div class="card mb-4 shadow-sm">
          <div class="card-header">
            <h4 class="my-0 font-weight-normal">E-Learning</h4>
          </div>
          <div class="card-body">
            <ul class="list-unstyled mt-3 mb-4">
              <li>Gestione Docenti</li>
              <li>Gestione Sedi</li>
              <li>Operazioni Frequenze</li>
            </ul>
            <a type="button" class="btn btn-dark btn-lg" href="elearning.jsp" >Entra</a>
          </div>
        </div>
      </div>

			

	</form>

    
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    
    <script src="js/bootstrap.min.js"></script>	
  </body>
</html>