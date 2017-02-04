package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import domain.model.Doctor;



@WebServlet("/doctorServlet")
public class DoctorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Doctor doctor = new Doctor();
		doctor.setPosition(request.getParameter("position"));
		doctor.setStatusDoctor(request.getParameter("statusDoctor"));

		HttpSession session = request.getSession();
		session.setAttribute("doctor", doctor);
		response.sendRedirect("final.jsp");
	}

}
