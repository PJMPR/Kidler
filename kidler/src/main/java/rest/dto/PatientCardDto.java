package rest.dto;

import javax.xml.bind.annotation.XmlRootElement;
import domain.model.Status;

@XmlRootElement
public class PatientCardDto {

	private int id;
	private int roomNumber;
	private Status status;
	private String historyOfDiseases;
	private String ailments;
	
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
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
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
}
