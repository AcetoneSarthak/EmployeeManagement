package employeemanagement.exception;

public class EmployeeException extends Exception {
	String errorCode;
	String errorMessage;
	
	public EmployeeException(String errorCode, String errorMessage) {
		super(String.format(errorCode,errorMessage));
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
	
	

}
