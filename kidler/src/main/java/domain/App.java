package domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import dao.RepositoryCatalog;
import dao.repositories.IRepositoryCatalog;
import dao.uow.IUnitOfWork;
import dao.uow.UnitOfWork;
import domain.model.Doctor;
import domain.model.PatientCard;
import domain.model.Person;
import domain.model.Status;
import domain.model.StatusDoctor;

public class App 
{
    public static void main( String[] args )
    {
    	Person person1 = new Person();
    	Person person2 = new Person();
    	
    	
    	person1.setName("Kamil");
    	person1.setSurname("Kowalski");
    	person1.setBirthDate("10-09-1966");
    	person1.setPersonalIdentityNumber("660910157");
    	person1.setPhoneNumber("111222333");
    	person1.setEmail("Kowalski@kappa.pl");
    	
    	
    	person2.setName("Wojciech");
    	person2.setSurname("Wojcik");
    	person2.setBirthDate("12-11-1982");
    	person2.setPersonalIdentityNumber("821112909");
    	person2.setPhoneNumber("333111222");
    	person2.setEmail("Wojcik@kappa.pl");
    	
    	
    	Doctor doctor = new Doctor();
    	
    	
    	doctor.setPosition("szef");
    	doctor.setStatusDoctor(StatusDoctor.free.toString());
    	
    	
    	PatientCard patientCard = new PatientCard();
    	
    	
    	patientCard.setRoomNumber(112);
    	patientCard.setStatus(Status.residency.toString());
    	patientCard.setHistoryOfDiseases("Pierwsza wizyta w szpitalu");
    	patientCard.setAilments("zlamanie otwarte prawej nogi");
    	patientCard.setPersonId(2);
    	patientCard.setDoctorId(1);
    	
    	try {
			Connection connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/workdb");
			IUnitOfWork uow = new UnitOfWork(connection);
			IRepositoryCatalog catalog = new RepositoryCatalog(connection, uow);
			catalog.People().add (person1);
			catalog.People().add (person2);
			catalog.Doctors().add(doctor);
			catalog.PatientCards().add(patientCard);
			catalog.save();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    	
    	
    	
    	
    	
    	
    	
    	}
}
