package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.model.PatientCard;
import domain.model.Person;

@WebServlet("/patientCardServlet")
public class PatientCardServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        Person person = (Person) session.getAttribute("person");
        if(person==null)
        { 
        	response.sendRedirect("registerPerson.html");
        }
		PatientCard patientCard = new PatientCard();
		patientCard.setRoomNumber(Integer.parseInt(request.getParameter("roomNumber")));
		patientCard.setStatus(request.getParameter("status"));
		patientCard.setHistoryOfDiseases(request.getParameter("historyOfDiseases"));
		patientCard.setAilments(request.getParameter("ailments"));
		patientCard.setPersonId(Integer.parseInt(request.getParameter("personId")));
		patientCard.setDoctorId(Integer.parseInt(request.getParameter("doctorId")));
		session.setAttribute("patientCard", patientCard);
		response.sendRedirect("final.jsp");
	}
}
