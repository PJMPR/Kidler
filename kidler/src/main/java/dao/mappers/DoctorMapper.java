package dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import domain.model.Doctor;

public class DoctorMapper implements IMapResultSetIntoEntity<Doctor>{

	public Doctor map(ResultSet rs) throws SQLException {
		Doctor doctor = new Doctor();
		doctor.setId(rs.getInt("id"));
		doctor.setName(rs.getString("name"));
		doctor.setSurname(rs.getString("surname"));
		doctor.setBirthDate(rs.getString("birthDate"));
		doctor.setPersonalIdentityNumber(rs.getString("personalIdentityNumber"));
		doctor.setPhoneNumber(rs.getString("phoneNumber"));
		doctor.setEmail(rs.getString("email"));
		doctor.setPosition(rs.getString("position"));
		doctor.setSalary(rs.getInt("salary"));
		return doctor;
	}
	
}
