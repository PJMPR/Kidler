<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="domain.model.Person" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	    Person person = (Person) session.getAttribute("person");
	%>
	<h1>Gracz</h1>
	<h2>Imie: <%=person.getName() %></h2>
	<h2>Nazwisko: <%=person.getSurname() %></h2>
	<h2>Data Urodzenia: <%=person.getBirthDate() %></h2>
	<h2>PESEL: <%=person.getPersonalIdentityNumber() %></h2>
	<h2>Numer telefonu: <%=person.getPhoneNumber() %></h2>
	<h2>Email: <%=person.getEmail() %></h2>
<form action="personServlet" method="get">
Pozycja:<br />
<input name="position" value="Kardiohirurg" required /><br />
Nawisko:<br />
<input name="surname" value="Kowalski" required /><br />
Data Urodyenia:<br />
<input name="birthDate" value="10-09-1966" required/><br />
Pesel:<br />
<input name="personalIdentityNumber" value="660910157" required/><br />
Numer Telefonu:<br />
<input name="phoneNumber" value="111222333" required/><br />
Email:<br />
<input name="email" value="Kowalski@kappa.pl" required/><br />
<input type="submit" value="Wyślij"/>
</form>
</body>
</html>