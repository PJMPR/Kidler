package web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.RepositoryCatalog;
import dao.repositories.IRepositoryCatalog;
import dao.uow.IUnitOfWork;
import dao.uow.UnitOfWork;
import domain.model.Doctor;
import domain.model.PatientCard;
import domain.model.Person;



@WebServlet("/DbServlet")
public class DbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public DbServlet() {
        super();
     
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Connection connection;
		try {
			connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/workdb");
			IUnitOfWork uow = new UnitOfWork(connection);
			IRepositoryCatalog catalog = new RepositoryCatalog(connection, uow);
			HttpSession session = request.getSession();
			Doctor doctor = (Doctor) session.getAttribute("doctor");
			Person person = (Person) session.getAttribute("person");
			PatientCard patientCard = (PatientCard) session.getAttribute("patientCard");
			catalog.Doctors().add(doctor);
			catalog.save();
			catalog.People().add(person);
			catalog.PatientCards().add(patientCard);
			
			
			response.sendRedirect("index.html");
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
	}
	

	

}
