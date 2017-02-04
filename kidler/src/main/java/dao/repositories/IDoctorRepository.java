package dao.repositories;

import java.util.List;

import domain.model.Doctor;



public interface IDoctorRepository extends IRepository<Doctor>{
	
	public List<Doctor> withPosition (String position);
	public List<Doctor> withPerson (String person);
	
}
