package net.codingartist.algo_ds.exceptions;

public class EmptyDataStructureException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmptyDataStructureException(){
		super();
	}
	
	public EmptyDataStructureException(String message){
		super(message);
	}
	
	public EmptyDataStructureException(String message, Throwable cause){
		super(message, cause);
	}
}
