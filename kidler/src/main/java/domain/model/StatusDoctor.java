package domain.model;

public enum StatusDoctor {
	
	free, busy;
	
	public static StatusDoctor getByName(String enumName){
	   	 for (StatusDoctor status : StatusDoctor.values()) {
	   		 if (status.toString().equalsIgnoreCase(enumName)){
	   			 return status;
	   		 }    	 
	   	 }
	   	 return null;
	
	}
}

