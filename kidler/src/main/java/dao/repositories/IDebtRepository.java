package dao.repositories;

import java.util.List;

import domain.model.Debt;



public interface IDebtRepository extends IRepository <Debt>{

	public List<Debt> fromPatientCardId (int patientCardId);
}
