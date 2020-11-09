package net.codingartist.algo_ds.exceptions;

public class CloneFailedException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CloneFailedException(){
		super();
	}
	
	public CloneFailedException(String message){
		super(message);
	}
	
	public CloneFailedException(String message, Throwable cause){
		super(message, cause);
	}
}
