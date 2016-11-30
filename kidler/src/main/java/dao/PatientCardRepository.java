package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.mappers.IMapResultSetIntoEntity;
import dao.repositories.IPatientCardRepository;
import dao.uow.IUnitOfWork;
import domain.model.PatientCard;

public class PatientCardRepository extends RepositoryBase <PatientCard> implements IPatientCardRepository {
	
	private PreparedStatement getName;
	private PreparedStatement getSurname;
	private PreparedStatement getRoomId;
	
	public PatientCardRepository(Connection connection,
			IMapResultSetIntoEntity <PatientCard> mapper, IUnitOfWork uow) {
		super(connection,mapper, uow);
		try {
			getName = connection.prepareStatement(getNameSql());
			getSurname = connection.prepareStatement(getSurnameSql());
			getRoomId= connection.prepareStatement(getRoomIdSql());

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	@Override
	protected String createTableSql() {
		return "" + "CREATE TABLE patientCard("
				+ "id bigint GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,"
				+ "name varchar(20)," + "surname varchar(20)"  
				+ "birthDate DATE," + "personalIdentityNumber varchar(15),"
				+ "phoneNumber varchar(20)," + "email varchar (30),"
				+ "status varchar(20)," + "historyOfDiseases varchar (1000),"
				+ "ailments varchar (500)"
				+")";
	}

	@Override
	protected String tableName() {
		return "patientCard";
	}

	@Override
	protected String insertSql() {
		// TODO Auto-generated method stub
		return "INSERT INTO patientCard (name, surname, birthDate, personalIdentityNumber, phoneNumber, email, roomId, status, historyOfDiseases, ailments) VALUES (?,?,?,?,?,?,?,?,?,?)";
	}

	@Override
	protected String updateSql() {
		// TODO Auto-generated method stub
		return "UPDATE patientCard SET (name, surname, birthDate, personalIdentityNumber, phoneNumber, email, roomId, status, historyOfDiseases, ailments)=(?,?,?,?,?,?,?,?,?,?) where id=?";
	}

	@Override
	protected void setUpdate(PatientCard entity) throws SQLException {
		// TODO Auto-generated method stub
		update.setString(1, entity.getName());
		update.setString(2, entity.getSurname());
		update.setDate(3, entity.getBirthDate());
		update.setString(4, entity.getPersonalIdentityNumber());
		update.setString(5, entity.getPhoneNumber());
		update.setString(6, entity.getEmail());
		update.setInt(7, entity.getRoomId());
		update.setObject(8, entity.getStatus());
		update.setString(9, entity.getHistoryOfDiseases());
		update.setString(10, entity.getAilments());
		
	}

	@Override
	protected void setInsert(PatientCard entity) throws SQLException {
		// TODO Auto-generated method stub
		insert.setString(1, entity.getName());
		insert.setString(2, entity.getSurname());
		insert.setDate(3, entity.getBirthDate());
		insert.setString(4, entity.getPersonalIdentityNumber());
		insert.setString(5, entity.getPhoneNumber());
		insert.setString(6, entity.getEmail());
		insert.setInt(7, entity.getRoomId());
		insert.setObject(8, entity.getStatus());
		insert.setString(9, entity.getHistoryOfDiseases());
		insert.setString(10, entity.getAilments());
		
	}


	private String getRoomIdSql() {
		// TODO Auto-generated method stub
		return "SELECT * FROM patientCard where roomId = ?";
	}


	private String getSurnameSql() {
		// TODO Auto-generated method stub
		return "SELECT * FROM patientCard where surname = ?";
	}


	private String getNameSql() {
		// TODO Auto-generated method stub
		return "SELECT * FROM patientCard where name = ?";
	}


	public List<PatientCard> fromName(String name) {
		// TODO Auto-generated method stub
		List<PatientCard> patientCard = new ArrayList<PatientCard>();
		try{
		getName.setString(1,name);
		ResultSet resultSet = getName.executeQuery();
		while(resultSet.next()){
			patientCard.add(mapper.map(resultSet));
		}
		}
		catch (SQLException e)
		{
		e.printStackTrace();
		}
		return patientCard;
	}


	public List<PatientCard> fromSurname(String surname) {
		// TODO Auto-generated method stub
		List<PatientCard> patientCard = new ArrayList<PatientCard>();
		try{
		getSurname.setString(1,surname);
		ResultSet resultSet = getSurname.executeQuery();
		while(resultSet.next()){
			patientCard.add(mapper.map(resultSet));
		}
		}
		catch (SQLException e)
		{
		e.printStackTrace();
		}
		return patientCard;
	}


	public List<PatientCard> fromRoomId(int roomId) {
		// TODO Auto-generated method stub
		List<PatientCard> patientCard = new ArrayList<PatientCard>();
		try{
		getRoomId.setInt(1,roomId);
		ResultSet resultSet = getRoomId.executeQuery();
		while(resultSet.next()){
			patientCard.add(mapper.map(resultSet));
		}
		}
		catch (SQLException e)
		{
		e.printStackTrace();
		}
		return patientCard;
	}
	
}

