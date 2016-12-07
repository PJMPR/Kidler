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
	
	private PreparedStatement getRoomNumber;
	private PreparedStatement getPersonId;
	private PreparedStatement getDoctorId;
	
	public PatientCardRepository(Connection connection,
			IMapResultSetIntoEntity <PatientCard> mapper, IUnitOfWork uow) {
		super(connection,mapper, uow);
		try {
			getPersonId = connection.prepareStatement(getNameSql());
			getDoctorId = connection.prepareStatement(getSurnameSql());
			getRoomNumber= connection.prepareStatement(getRoomIdSql());

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	@Override
	protected String createTableSql() {
		return "" + "CREATE TABLE patientCard("
				+ "id bigint GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,"
				+ "roomNumber int," + "status varchar(20),"
				+ "historyOfDiseases varchar (1000)," + "ailments varchar (500)"
				+ "personId int," + "doctorId int,"
				+")";
	}

	@Override
	protected String tableName() {
		return "patientCard";
	}

	@Override
	protected String insertSql() {
		// TODO Auto-generated method stub
		return "INSERT INTO patientCard (roomNumber, status, historyOfDiseases, ailments, personId, doctorId) VALUES (?,?,?,?,?,?)";
	}

	@Override
	protected String updateSql() {
		// TODO Auto-generated method stub
		return "UPDATE patientCard SET (roomNumber, status, historyOfDiseases, ailments, personId, doctorId)=(?,?,?,?,?,?) where id=?";
	}

	@Override
	protected void setUpdate(PatientCard entity) throws SQLException {
		// TODO Auto-generated method stub
		update.setInt(1, entity.getRoomNumber());
		update.setString(2, entity.getStatus().toString());
		update.setString(3, entity.getHistoryOfDiseases());
		update.setString(4, entity.getAilments());
		update.setInt(5, entity.getPersonId());
		update.setInt(6, entity.getDoctorId());
		
	}

	@Override
	protected void setInsert(PatientCard entity) throws SQLException {
		// TODO Auto-generated method stub
		insert.setInt(1, entity.getRoomNumber());
		insert.setObject(2, entity.getStatus());
		insert.setString(3, entity.getHistoryOfDiseases());
		insert.setString(4, entity.getAilments());
		insert.setInt(5, entity.getPersonId());
		insert.setInt(6, entity.getDoctorId());
		
	}


	private String getRoomIdSql() {
		// TODO Auto-generated method stub
		return "SELECT * FROM patientCard where roomNumber = ?";
	}


	private String getSurnameSql() {
		// TODO Auto-generated method stub
		return "SELECT * FROM patientCard where surname = ?";
	}


	private String getNameSql() {
		// TODO Auto-generated method stub
		return "SELECT * FROM patientCard where name = ?";
	}


	public List<PatientCard> fromPersonId(int personId) {
		// TODO Auto-generated method stub
		List<PatientCard> patientCard = new ArrayList<PatientCard>();
		try{
		getPersonId.setInt(1,personId);
		ResultSet resultSet = getPersonId.executeQuery();
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


	public List<PatientCard> fromDoctorId(int doctorId) {
		// TODO Auto-generated method stub
		List<PatientCard> patientCard = new ArrayList<PatientCard>();
		try{
		getDoctorId.setInt(1,doctorId);
		ResultSet resultSet = getDoctorId.executeQuery();
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


	public List<PatientCard> fromRoomNumber(int roomNumber) {
		// TODO Auto-generated method stub
		List<PatientCard> patientCard = new ArrayList<PatientCard>();
		try{
		getRoomNumber.setInt(1,roomNumber);
		ResultSet resultSet = getRoomNumber.executeQuery();
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

