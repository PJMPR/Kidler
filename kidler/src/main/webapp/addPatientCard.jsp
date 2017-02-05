<%@page import="java.util.Arrays"%>
<%@page import="domain.model.Status"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<body>
<form enctype="text/plain">
Numer pokoju:<br />
<input name="roomNumber" value="12" required /><br />

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
                        </select><br/>
Historia chorób:<br />
<textarea name="historyOfDiseases"/>Bla bla aasdhdkjashkjqwhkjhdkjashdkjashk</textarea><br />
Należności:<br />
<input name="ailments" value="0" required /><br />
Numer indeksu doktora:<br />
<input name="doctorId" value="1" required /><br />
	
		<input type = "submit" formaction="patientCardServlet" value = "Utwórz!" /> <br />
        </form>              
</body>
</html>