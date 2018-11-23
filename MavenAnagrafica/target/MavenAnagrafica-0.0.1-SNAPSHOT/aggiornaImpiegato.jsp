<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="ImpiegatoServlet" method="get">
		<font color=red>Modifica tramite ID:</font><br> <input type="text" name="id">
		<br> <input type="hidden" name="funzione" value="cercaid">
		<input type="submit" value="Modifica"><br>
	</form>

</body>
</html>