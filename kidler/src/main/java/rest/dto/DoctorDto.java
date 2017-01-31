package rest.dto;

import javax.xml.bind.annotation.XmlRootElement;

import domain.model.StatusDoctor;

@XmlRootElement
public class DoctorDto {

	private int id;
	private String position;
	private StatusDoctor statusDoctor;
	private int PersonId;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public StatusDoctor getStatusDoctor() {
		return statusDoctor;
	}
	public void setStatusDoctor(StatusDoctor statusDoctor) {
		this.statusDoctor = statusDoctor;
	}
	public int getPersonId() {
		return PersonId;
	}
	public void setPersonId(int personId) {
		PersonId = personId;
	}
	
	
}
