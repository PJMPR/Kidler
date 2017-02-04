package domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name="doctor")
@NamedQueries({
       @NamedQuery(name = "doctor.all", query = "SELECT p FROM Doctor p"),
       @NamedQuery(name = "doctor.id", query = "SELECT p FROM Doctor p WHERE p.id=:id")
})

public class Doctor implements IHaveId{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String position;
	private String statusDoctor;
	@ManyToOne
	private Person person;
	
	
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
	public String getStatusDoctor() {
		return statusDoctor;
	}
	public void setStatusDoctor(String statusDoctor) {
		this.statusDoctor = statusDoctor;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
		
	}

