package dao.repositories;

import java.util.List;

import domain.model.PatientCard;

public interface IPatientCardRepository extends IRepository <PatientCard>{

	public List<PatientCard> fromStatus (String status);
}
