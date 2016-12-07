package dao.repositories;

import java.util.List;

import domain.model.PatientCard;

public interface IPatientCardRepository extends IRepository <PatientCard>{

	public List<PatientCard> fromPersonId (int personId);
	public List<PatientCard> fromDoctorId (int doctorId);
	public List<PatientCard> fromRoomNumber (int roomNumber);
}
