package dao.repositories;

import java.util.List;

import domain.model.Doctor;



public interface IDoctorRepository extends IRepository<Doctor>{
	
	public List<Doctor> fromPosition (String position);
	public List<Doctor> fromPersonId (int personId);
}
