package dao;

import java.sql.Connection;

import dao.mappers.DebtMapper;
import dao.mappers.DoctorMapper;
import dao.mappers.EnumDictionaryMapper;
import dao.mappers.OperationMapper;
import dao.mappers.PatientCardMapper;
import dao.mappers.PersonMapper;
import dao.repositories.IDebtRepository;
import dao.repositories.IDoctorRepository;
import dao.repositories.IEnumDictionariesRepository;
import dao.repositories.IOperationRepository;
import dao.repositories.IPatientCardRepository;
import dao.repositories.IPersonRepository;
import dao.repositories.IRepositoryCatalog;
import dao.uow.IUnitOfWork;

public class RepositoryCatalog implements IRepositoryCatalog {

	private Connection connection;
	private IUnitOfWork uow;

	public RepositoryCatalog(Connection connection,IUnitOfWork uow)
	{
		this.connection = connection;
		this.uow = uow;
	}

	public IDebtRepository Debt() {
		return new DebtRepository(connection, new DebtMapper(), uow);
	}

	public IDoctorRepository Doctor() {
		return new DoctorRepository(connection, new DoctorMapper(), uow);
	}

	public IEnumDictionariesRepository EnumDictionary() {
		return new EnumDictionaryRepository(connection, new EnumDictionaryMapper(), uow);
	}

	public IOperationRepository Operation() {
		return new OperationRepository(connection, new OperationMapper(), uow);
	}

	public IPatientCardRepository PatientCard() {
		return new PatientCardRepository(connection, new PatientCardMapper(), uow);
	}

	public IPersonRepository Person() {
		return new PersonRepository(connection, new PersonMapper(), uow);
	}
	
	public void save() {
		uow.saveChanges();

	}

}
