package dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import domain.model.Doctor;
import domain.model.StatusDoctor;

public class DoctorMapper implements IMapResultSetIntoEntity<Doctor>{

	public Doctor map(ResultSet rs) throws SQLException {
		Doctor doctor = new Doctor();
		doctor.setId(rs.getInt("id"));
		doctor.setPosition(rs.getString("position"));
		doctor.setStatusDoctor(rs.getString("statusDoctor"));
		
		return doctor;
	}
	
}
