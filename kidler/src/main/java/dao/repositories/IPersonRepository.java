package dao.repositories;

import java.util.List;
import domain.model.Person;

public interface IPersonRepository extends IRepository <Person>{

	public List<Person> fromName (String name);
	public List<Person> fromSurname (String surname);
}