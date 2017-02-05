package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.model.Doctor;
import domain.model.PatientCard;
import domain.model.Person;

@WebServlet("/patientCardServlet")
public class PatientCardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PatientCard patientCard = new PatientCard();
		Doctor doctor = new Doctor();
		patientCard.setRoomNumber(Integer.parseInt(request.getParameter("roomNumber")));
		patientCard.setStatus(request.getParameter("status"));
		patientCard.setHistoryOfDiseases(request.getParameter("historyOfDiseases"));
		patientCard.setAilments(request.getParameter("ailments"));
		int doctorId = (Integer.parseInt(request.getParameter("doctorId")));
		doctor.setId(doctorId);
		patientCard.setDoctor(doctor);
		HttpSession session = request.getSession();
		session.setAttribute("patientCard", patientCard);
		response.sendRedirect("finalSecond.jsp");
		
	}
}