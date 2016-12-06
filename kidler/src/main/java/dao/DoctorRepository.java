package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dao.mappers.IMapResultSetIntoEntity;
import dao.repositories.IDoctorRepository;
import dao.uow.IUnitOfWork;
import domain.model.Doctor;


public class DoctorRepository extends RepositoryBase <Doctor> implements IDoctorRepository {
	
	private PreparedStatement getName;
	private PreparedStatement getSurname;
	private PreparedStatement getBirthDate;
	private PreparedStatement getPosition;
	
	public DoctorRepository(Connection connection,
			IMapResultSetIntoEntity <Doctor> mapper, IUnitOfWork uow) {
		super(connection,mapper, uow);
		try {
			getName = connection.prepareStatement(getNameSql());
			getSurname = connection.prepareStatement(getSurnameSql());
			getBirthDate= connection.prepareStatement(getBirthDateSql());
			getPosition = connection.prepareStatement(getPositionSql());

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	@Override
	protected String createTableSql() {
		return "" + "CREATE TABLE doctor("
				+ "id bigint GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,"
				+ "name varchar(20)," + "surname varchar(20)"  
				+ "birthDate DATE," + "personalIdentityNumber varchar(15),"
				+ "phoneNumber varchar(20)," + "email varchar (30),"
				+ "position varchar(20)," + "salary int (10)"
				+")";
	}

	@Override
	protected String tableName() {
		return "doctor";
	}

	@Override
	protected String insertSql() {
		// TODO Auto-generated method stub
		return "INSERT INTO doctor (name, surname, birthDate, personalIdentityNumber, phoneNumber, email, position, salary) VALUES (?,?,?,?,?,?,?,?)";
	}

	@Override
	protected String updateSql() {
		// TODO Auto-generated method stub
		return "UPDATE doctor SET (name, surname, birthDate, personalIdentityNumber, phoneNumber, email, position, salary)=(?,?,?,?,?,?,?,?) where id=?";
	}

	@Override
	protected void setUpdate(Doctor entity) throws SQLException {
		// TODO Auto-generated method stub
		update.setString(1, entity.getName());
		update.setString(2, entity.getSurname());
		update.setString(3, entity.getBirthDate());
		update.setString(4, entity.getPersonalIdentityNumber());
		update.setString(5, entity.getPhoneNumber());
		update.setString(6, entity.getEmail());
		update.setString(7, entity.getPosition());
		update.setInt(8, entity.getSalary());
		
	}

	@Override
	protected void setInsert(Doctor entity) throws SQLException {
		// TODO Auto-generated method stub
		insert.setString(1, entity.getName());
		insert.setString(2, entity.getSurname());
		insert.setString(3, entity.getBirthDate());
		insert.setString(4, entity.getPersonalIdentityNumber());
		insert.setString(5, entity.getPhoneNumber());
		insert.setString(6, entity.getEmail());
		insert.setString(7, entity.getPosition());
		insert.setInt(8, entity.getSalary());
		
	}
	
	private String getPositionSql() {
		// TODO Auto-generated method stub
		return "SELECT * FROM doctor where position = ?";
	}


	private String getBirthDateSql() {
		// TODO Auto-generated method stub
		return "SELECT * FROM doctor where birthDate = ?";
	}


	private String getSurnameSql() {
		// TODO Auto-generated method stub
		return "SELECT * FROM doctor where surname = ?";
	}


	private String getNameSql() {
		// TODO Auto-generated method stub
		return "SELECT * FROM doctor where name = ?";
	}


	public List<Doctor> fromName(String name) {
		// TODO Auto-generated method stub
		List<Doctor> doctor = new ArrayList<Doctor>();
		try{
		getName.setString(1,name);
		ResultSet resultSet = getName.executeQuery();
		while(resultSet.next()){
		doctor.add(mapper.map(resultSet));
		}
		}
		catch (SQLException e)
		{
		e.printStackTrace();
		}
		return doctor;
	}


	public List<Doctor> fromSurname(String surname) {
		// TODO Auto-generated method stub
		List<Doctor> doctor = new ArrayList<Doctor>();
		try{
		getSurname.setString(1,surname);
		ResultSet resultSet = getName.executeQuery();
		while(resultSet.next()){
		doctor.add(mapper.map(resultSet));
		}
		}
		catch (SQLException e)
		{
		e.printStackTrace();
		}
		return doctor;
	}


	public List<Doctor> fromBirthDate(Date birthDate) {
		// TODO Auto-generated method stub
		List<Doctor> doctor = new ArrayList<Doctor>();
		try{
		getBirthDate.setDate(1,(java.sql.Date) birthDate);
		ResultSet resultSet = getName.executeQuery();
		while(resultSet.next()){
		doctor.add(mapper.map(resultSet));
		}
		}
		catch (SQLException e)
		{
		e.printStackTrace();
		}
		return doctor;
	}


	public List<Doctor> fromPosition(String position) {
		// TODO Auto-generated method stub
		List<Doctor> doctor = new ArrayList<Doctor>();
		try{
		getPosition.setString(1,position);
		ResultSet resultSet = getName.executeQuery();
		while(resultSet.next()){
		doctor.add(mapper.map(resultSet));
		}
		}
		catch (SQLException e)
		{
		e.printStackTrace();
		}
		return doctor;
	}

	
	
}
