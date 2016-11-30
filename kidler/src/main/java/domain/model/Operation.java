package domain.model;

public class Operation implements IHaveId{
	
	private int id;
	private int operationHall;
	private String supply;
	private int patientCardId;
	private int doctor1Id;
	private int doctor2Id;
	private int doctor3Id;
	
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
	public int getPatientCardId() {
		return patientCardId;
	}
	public void setPatientCardId(int patientCardId) {
		this.patientCardId = patientCardId;
	}
	public int getDoctor1Id() {
		return doctor1Id;
	}
	public void setDoctor1Id(int doctor1Id) {
		this.doctor1Id = doctor1Id;
	}
	public int getDoctor2Id() {
		return doctor2Id;
	}
	public void setDoctor2Id(int doctor2Id) {
		this.doctor2Id = doctor2Id;
	}
	public int getDoctor3Id() {
		return doctor3Id;
	}
	public void setDoctor3Id(int doctor3Id) {
		this.doctor3Id = doctor3Id;
	}

	

}
