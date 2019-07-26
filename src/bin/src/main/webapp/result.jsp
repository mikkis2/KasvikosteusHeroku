<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import ="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Kasvikosteus</title>
<style>
h1 {text-align:center;}
p {text-align:center;}
</style>
</head>
<body>
	<h1>Kasvikosteus</h1>
	<p>
	<%
	String tulos = (String) request.getAttribute("kosteus");
	String analysis = (String) request.getAttribute("analysis");
	out.println("Kasvisi kosteus on tällä hetkellä " + tulos + "%" +  "<br><br>");
	out.println(analysis);
	%>
	
	<br><br>
	<div align="center"><form method="post" action="/kasvikosteus" >
	<input type="submit" value="Palaa alkuun">
	</form></div>
</body>
</html>