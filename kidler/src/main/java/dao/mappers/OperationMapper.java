package dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import domain.model.Operation;

public class OperationMapper implements IMapResultSetIntoEntity<Operation>{

	public Operation map(ResultSet rs) throws SQLException {
		Operation operation = new Operation();
		operation.setId(rs.getInt("id"));
		operation.setOperationHall(rs.getInt("operationHall"));
		operation.setSupply(rs.getString("supply"));
		operation.setPatientCardId(rs.getInt("patientCardId"));
		operation.setDoctor1Id(rs.getInt("doctor1Id"));
		operation.setDoctor2Id(rs.getInt("doctor2Id"));
		operation.setDoctor3Id(rs.getInt("doctor3Id"));
		return operation;
	}
	
}
