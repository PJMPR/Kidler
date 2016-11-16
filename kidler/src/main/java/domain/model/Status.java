package domain.model;

public enum Status {
	
	visit, operation, control, residency;
	
	public static Status getByName(String enumName){
	   	 for (Status status : Status.values()) {
	   		 if (status.toString().equalsIgnoreCase(enumName)){
	   			 return status;
	   		 }    	 
	   	 }
	   	 return null;
	
	}
}
