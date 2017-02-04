<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.List" %>
    <%@page import="domain.model.Status" %>
    <%@page import="domain.App" %>
	<%@page import="java.util.Arrays" %>
	<%@page import="dao.RepositoryCatalog" %>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Karta Pacjenta</title>
</head>
<body>
<form action="patientCardServlet" method="get">
Numer pokoju:<br />
<input name="roomNumber" value="112" required /><br />
Status:<br />
                
             <select name="status">
                        <%
                        try {
                        	List<Status> statuses = Arrays.asList(Status.values());
                           for(Status status:statuses){
                        %><option value="<%=status%>"><%=status%></option>
                        <%
                           }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        %>
                    </select> </br>
Historia chorob:<br />
<input name="historyOfDiseases" value="Przewlekle chory na grypę zoladkowa spowodowana nadmierna iloscia alkoholu" required/><br />
Naleznosci:<br />
<input name="ailments" value="0" required/><br />
Numer identyfikacyjny osoby:<br />
<input name="personId" value="1" required/><br />
Numer identyfikacyjny doktora:<br />
<input name="doctorId" value="1" required/><br />
<input type="submit" value="Wyślij"/>
</form>
</body>
</html>