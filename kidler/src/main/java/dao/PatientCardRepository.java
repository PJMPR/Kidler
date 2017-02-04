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
	

	private PreparedStatement getStatus;
	
	public PatientCardRepository(Connection connection,
			IMapResultSetIntoEntity <PatientCard> mapper, IUnitOfWork uow) {
		super(connection,mapper, uow);
		try {
			getStatus= connection.prepareStatement(getStatusSql());

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	@Override
	protected String createTableSql() {
		return "" + "CREATE TABLE patientCard("
				+ "id bigint GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,"
				+ "roomNumber int," + "status varchar(20),"
				+ "historyOfDiseases varchar (1000)," + "ailments varchar (500),"
				+ "personId int," + "doctorId int"
				+ "FOREIGN KEY (personId) REFERENCES person(id),"
				+ "FOREIGN KEY (doctorId) REFERENCES doctor(id),"
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
	protected String deleteSql() {	
		// TODO Auto-generated method stub
		return "DELETE FROM patientCard WHERE id=?";
	}
	
	@Override
	protected String selectAllSql() {
		// TODO Auto-generated method stub
		return "SELECT * FROM patientCard";
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
		insert.setString(2, entity.getStatus().toString());
		insert.setString(3, entity.getHistoryOfDiseases());
		insert.setString(4, entity.getAilments());
		insert.setInt(5, entity.getPersonId());
		insert.setInt(6, entity.getDoctorId());
		
	}

	
	private String getStatusSql() {
		// TODO Auto-generated method stub
		return "SELECT * FROM patientCard where status = ?";
	}


	@Override
	public List<PatientCard> fromStatus(String status) {
		// TODO Auto-generated method stub
		List<PatientCard> patientCard = new ArrayList<PatientCard>();
		try{
		
		getStatus.setString(1,status);
		ResultSet resultSet = getStatus.executeQuery();
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

