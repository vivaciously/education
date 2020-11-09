package net.codingartist.algo_ds.exceptions;

public class FullCapacityDataStructureException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public FullCapacityDataStructureException(){
		super();
	}
	
	public FullCapacityDataStructureException(String message){
		super(message);
	}
	
	public FullCapacityDataStructureException(String message, Throwable cause){
		super(message, cause);
	}
}
