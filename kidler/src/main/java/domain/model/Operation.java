package domain.model;

public class Operation {
	
	private int id;
	private int operationHall;
	private String supply;
	private PatientCard patientCard;
	private Doctor doctor1;
	private Doctor doctor2;
	private Doctor doctor3;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getOperationHall() {
		return operationHall;
	}
	public void setOperationHall(int operationHall) {
		this.operationHall = operationHall;
	}
	public String getSupply() {
		return supply;
	}
	public void setSupply(String supply) {
		this.supply = supply;
	}
	public PatientCard getPatientCard() {
		return patientCard;
	}
	public void setPatientCard(PatientCard patientCard) {
		this.patientCard = patientCard;
	}
	public Doctor getDoctor1() {
		return doctor1;
	}
	public void setDoctor1(Doctor doctor1) {
		this.doctor1 = doctor1;
	}
	public Doctor getDoctor2() {
		return doctor2;
	}
	public void setDoctor2(Doctor doctor2) {
		this.doctor2 = doctor2;
	}
	public Doctor getDoctor3() {
		return doctor3;
	}
	public void setDoctor3(Doctor doctor3) {
		this.doctor3 = doctor3;
	}
	

}
