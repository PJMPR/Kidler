package dao.repositories;

import java.util.List;

import domain.model.PatientCard;

public interface IPatientCardRepository extends IRepository <PatientCard>{

	public List<PatientCard> fromName (String name);
	public List<PatientCard> fromSurname (String surname);
	public List<PatientCard> fromRoomId (int roomId);
}
