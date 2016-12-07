package dao;

import java.sql.Connection;

import dao.mappers.DoctorMapper;
import dao.mappers.EnumDictionaryMapper;
import dao.mappers.PatientCardMapper;
import dao.mappers.PersonMapper;
import dao.repositories.IDoctorRepository;
import dao.repositories.IEnumDictionariesRepository;
import dao.repositories.IPatientCardRepository;
import dao.repositories.IPersonRepository;
import dao.repositories.IRepositoryCatalog;
import dao.uow.IUnitOfWork;

public class RepositoryCatalog implements IRepositoryCatalog {

	private Connection connection;
	private IUnitOfWork uow;
	private EnumDictionaryMapper enumDictionaryMapper = new EnumDictionaryMapper();
	private DoctorMapper doctorMapper = new DoctorMapper();
	private PatientCardMapper patientCardMapper = new PatientCardMapper();
	private PersonMapper personMapper = new PersonMapper();

	public RepositoryCatalog(Connection connection,IUnitOfWork uow)
	{
		this.connection = connection;
		this.uow = uow;
	}

	public IDoctorRepository Doctors() {
		return new DoctorRepository(connection, doctorMapper, uow);
	}

	public IEnumDictionariesRepository Dictionaries() {
		return new EnumDictionaryRepository(connection, enumDictionaryMapper, uow);
	}

	public IPatientCardRepository PatientCards() {
		return new PatientCardRepository(connection, patientCardMapper, uow);
	}

	public IPersonRepository People() {
		return new PersonRepository(connection, personMapper, uow);
	}
	
	public void save() {
		uow.saveChanges();

	}

}
