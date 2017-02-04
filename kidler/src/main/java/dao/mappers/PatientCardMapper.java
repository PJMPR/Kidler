package dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import domain.model.PatientCard;
import domain.model.Status;

public class PatientCardMapper implements IMapResultSetIntoEntity<PatientCard>{

	public PatientCard map(ResultSet rs) throws SQLException {
		PatientCard patientCard = new PatientCard();
		patientCard.setId(rs.getInt("id"));
		patientCard.setRoomNumber(rs.getInt("roomNumber"));
		patientCard.setStatus(rs.getString("status"));
		patientCard.setHistoryOfDiseases(rs.getString("historyOfDiseases"));
		patientCard.setAilments(rs.getString("ailments"));
		patientCard.setPersonId(rs.getInt("PersonId"));
		patientCard.setDoctorId(rs.getInt("DoctorId"));
		return patientCard;
	}
	
}
