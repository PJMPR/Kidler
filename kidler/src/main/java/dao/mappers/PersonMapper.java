package dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import domain.model.Person;

public class PersonMapper implements IMapResultSetIntoEntity<Person> {

	public Person map(ResultSet rs) throws SQLException {
		Person person = new Person();
		person.setId(rs.getInt("id"));
		person.setName(rs.getString("name"));
		person.setSurname(rs.getString("surname"));
		person.setBirthDate(rs.getString("birthDate"));
		person.setPersonalIdentityNumber(rs.getString("personalIdentityNumber"));
		person.setPhoneNumber(rs.getString("phoneNumber"));
		person.setEmail(rs.getString("email"));
		return person;
	}
}
