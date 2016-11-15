package domain.model;

import java.math.BigDecimal;

public class Doctor extends Person{
	
	private String position;
	private BigDecimal salary;
	
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public BigDecimal getSalary() {
		return salary;
	}
	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}


}
