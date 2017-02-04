package domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name="patientCard")
@NamedQueries({
       @NamedQuery(name = "patientCard.all", query = "SELECT p FROM PatientCard p"),
       @NamedQuery(name = "patientCard.id", query = "SELECT p FROM PatientCard p WHERE p.id=:id")
})
public class PatientCard implements IHaveId{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int roomNumber;
	private String status;
	private String historyOfDiseases;
	private String ailments;
	private int personId;
	private int doctorId;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getHistoryOfDiseases() {
		return historyOfDiseases;
	}
	public void setHistoryOfDiseases(String historyOfDiseases) {
		this.historyOfDiseases = historyOfDiseases;
	}
	public String getAilments() {
		return ailments;
	}
	public void setAilments(String ailments) {
		this.ailments = ailments;
	}
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
	}
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	

}
