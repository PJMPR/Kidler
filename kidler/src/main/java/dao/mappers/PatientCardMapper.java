package dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import domain.model.PatientCard;

public class PatientCardMapper implements IMapResultSetIntoEntity<PatientCard>{

	public PatientCard map(ResultSet rs) throws SQLException {
		PatientCard patientCard = new PatientCard();
		patientCard.setId(rs.getInt("id"));
		patientCard.setName(rs.getString("name"));
		patientCard.setSurname(rs.getString("surname"));
		patientCard.setBirthDate(rs.getDate("birthDate"));
		patientCard.setPersonalIdentityNumber(rs.getString("personalIdentityNumber"));
		patientCard.setPhoneNumber(rs.getString("phoneNumber"));
		patientCard.setEmail(rs.getString("email"));
		patientCard.setRoomId(rs.getInt("roomId"));
		//result.setStatus(rs.getString("status"));
		patientCard.setHistoryOfDiseases(rs.getString("historyOfDiseases"));
		patientCard.setAilments(rs.getString("Ailments"));
		return patientCard;
	}
	
}
