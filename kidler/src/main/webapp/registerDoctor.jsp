<%@page import="java.util.Arrays"%>
<%@page import="domain.model.StatusDoctor"%>
<%@page import="domain.model.Position"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<body>
<form enctype="text/plain">

Pozycja:<br />
				<select name="position">
                        <%
                        try {
                        	List<Position> positions = Arrays.asList(Position.values());
                           for(Position position:positions){
                        %><option value="<%=position%>"><%=position%></option>
                        <%
                           }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        %>
                        </select> <br/>
    	Status:<br />
                <select name="statusDoctor">
                        <%
                        try {
                        	List<StatusDoctor> statusDoctors = Arrays.asList(StatusDoctor.values());
                           for(StatusDoctor statusDoctor:statusDoctors){
                        %><option value="<%=statusDoctor%>"><%=statusDoctor%></option>
                        <%
                           }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        %>
                        </select> <br/>

				
		<input type = "submit" formaction="doctorServlet" value = "Utwórz!" /> <br />
        </form>              
</body>
</html>