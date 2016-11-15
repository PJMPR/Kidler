package domain.model;

public class PatientCard extends Person {
	
	private int roomID;
	private Status status;
	private String historyOfDiseases;
	private String ailments;
	
	public int getRoomID() {
		return roomID;
	}
	public void setRoomID(int roomID) {
		this.roomID = roomID;
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
