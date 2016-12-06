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

public class App 
{
    public static void main( String[] args )
    {
    	Person person = new Person();
    	person.setName("Jarek");
    	person.setSurname("Kowalski");
    	person.setBirthDate("1967-09-12");
    	person.setPersonalIdentityNumber("670912315");
    	person.setPhoneNumber("161787555");
    	person.setEmail("Kowalski@email.com");
        
        Doctor doctor = new Doctor();
        doctor.setPosition("Main Surgeon");
        doctor.setSalary(10000);
    	
    	PatientCard patientCard = new PatientCard();
    	patientCard.setRoomId(123);
    	patientCard.setStatus(Status.residency);
    	patientCard.setHistoryOfDiseases("brak");
    	patientCard.setAilments("100");
    	
    	
    	try{
    
    	Connection connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/workdb");
		IUnitOfWork uow = new UnitOfWork(connection);
		IRepositoryCatalog catalog = new RepositoryCatalog(connection, uow);
		catalog.Person().add(person);
		catalog.Doctor().add(doctor);
		catalog.PatientCard().add(patientCard);
		catalog.save();
    	}catch(SQLException e){
    		
    		e.printStackTrace();
    	}
    	
    	}
}
