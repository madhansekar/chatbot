package com.ey.poc.customexception;

public class InvalidRecordException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3891115705364283598L;
	
	public InvalidRecordException()
	{
		
	}
	
	public InvalidRecordException(String message)
	{
		super(message);
	}
	
	public InvalidRecordException(Throwable cause)
	{
		super(cause);
	}
	
	public InvalidRecordException(Throwable cause,String message, boolean suppress, boolean writbleStacktrace)
	{
		super(message,cause,suppress,writbleStacktrace);
	}

}
