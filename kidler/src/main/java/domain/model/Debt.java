package domain.model;

import java.math.BigDecimal;

public class Debt implements IHaveId{
	
	private int id;
	private int patientCardId;
	private BigDecimal payment;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPatientCardId() {
		return patientCardId;
	}
	public void setPatientCardId(int patientCardId) {
		this.patientCardId = patientCardId;
	}
	public BigDecimal getPayment() {
		return payment;
	}
	public void setPayment(BigDecimal payment) {
		this.payment = payment;
	}

}
