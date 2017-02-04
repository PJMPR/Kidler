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
@Table(name="person")
@NamedQueries({
       @NamedQuery(name = "person.all", query = "SELECT p FROM Person p"),
       @NamedQuery(name = "person.id", query = "SELECT p FROM Person p WHERE p.id=:id")
})

public class Person implements IHaveId{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
    private String name;
    private String surname;
    private String birthDate;
    private String personalIdentityNumber;
    private String phoneNumber;
    private String email;   
    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getPersonalIdentityNumber() {
		return personalIdentityNumber;
	}

	public void setPersonalIdentityNumber(String personalIdentityNumber) {
		this.personalIdentityNumber = personalIdentityNumber;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


}

