package dao.repositories;

import java.util.List;

import domain.model.Operation;

public interface IOperationRepository extends IRepository<Operation>{
	
	public List<Operation> fromOperationHall (int operationHall);
	public List<Operation> fromPatientCardId (int patientCardId);

}
