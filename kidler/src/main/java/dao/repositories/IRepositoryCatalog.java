package dao.repositories;

import java.sql.SQLException;

public interface IRepositoryCatalog {
	
	public IDoctorRepository Doctors();
	
	public IEnumDictionariesRepository Dictionaries();
	
	public IPatientCardRepository PatientCards();
	
	public IPersonRepository People();
	
	public void save() throws SQLException;

}