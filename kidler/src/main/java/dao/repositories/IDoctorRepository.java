package dao.repositories;

import java.util.Date;
import java.util.List;

import domain.model.Doctor;



public interface IDoctorRepository extends IRepository<Doctor>{
	
	public List<Doctor> fromName (String name);
	public List<Doctor> fromSurname (String surname);
	public List<Doctor> fromBirthDate (Date birthDate);
	public List<Doctor> fromPosition (String position);
}
