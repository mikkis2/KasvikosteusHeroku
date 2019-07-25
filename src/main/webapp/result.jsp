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
	String created_at_date = (String) request.getAttribute("created_at_date");
	String created_at_time = (String) request.getAttribute("created_at_time");
	String raw = (String) request.getAttribute("raw");
	
	out.println("Kasvisi kosteus on tällä hetkellä " + tulos + "%" +  "<br><br>");
	out.println(analysis);
	%>
	
	<br><br>
	<div align="center"><form method="post" action="/" >
	<input type="submit" value="Palaa alkuun">
	</form></div>
	<p>
	<%
	out.println("<br><br>");
	out.print("Updated on " + created_at_date + " at " + created_at_time + "<br>");
	out.println(raw);
	
	%>
</body>
</html>