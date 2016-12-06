package dao.repositories;

public interface IRepositoryCatalog {

	public IDebtRepository Debt();
	public IDoctorRepository Doctor();
	public IEnumDictionariesRepository EnumDictionary();
	public IOperationRepository Operation();
	public IPatientCardRepository PatientCard();
	public IPersonRepository Person();
	public void save();
}