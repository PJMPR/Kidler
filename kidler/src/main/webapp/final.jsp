<%@page import="domain.model.Person"%>
<%@page import="domain.model.PatientCard"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Zatwierdzenie</title>
</head>
<body>
	<%
	    Person person = (Person) session.getAttribute("person");
		PatientCard patientCard = (PatientCard) session.getAttribute("patientCard");
	%>
	<h1>Pacjent</h1>
	<h2>Imie: <%=person.getName() %></h2>
	<h2>Nazwisko: <%=person.getSurname() %></h2>
	<h2>Data Urodzenia: <%=person.getBirthDate() %></h2>
	<h2>PESEL: <%=person.getPersonalIdentityNumber() %></h2>
	<h2>Numer telefonu: <%=person.getPhoneNumber() %></h2>
	<h2>Email: <%=person.getEmail() %></h2>
	<h2>Numer pokoju: <%=person.getPersonalIdentityNumber() %></h2>
	<h2>Numer telefonu: <%=person.getPhoneNumber() %></h2>
	<h2>Status: <%=patientCard.getStatus() %></h2>
	<h2>Historia chorób: <%=patientCard.getHistoryOfDiseases() %></h2>
	<h2>Należności: <%=patientCard.getAilments() %></h2>
	
<h1>Wizyta zakonczona</h1>
<form action="DbServlet" method="get">
<input type=submit value="Potwierdz">
</form>
</body>
</html>