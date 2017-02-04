package dao.repositories;

import java.sql.SQLException;

import domain.model.Person;

public interface IRepositoryCatalog {
	
	public IDoctorRepository Doctors();
	
	public IPatientCardRepository PatientCards();
	
	public IPersonRepository People();
	
	public void save() throws SQLException;

}