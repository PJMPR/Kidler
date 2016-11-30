package domain.model;

import java.sql.Date;

public class Person implements IHaveId{

	private int id;
    private String name;
    private String surname;
    private Date birthDate;
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

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date date) {
		this.birthDate = date;
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

