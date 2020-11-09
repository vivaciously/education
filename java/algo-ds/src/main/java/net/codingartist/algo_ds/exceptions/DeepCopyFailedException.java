package net.codingartist.algo_ds.exceptions;

public class DeepCopyFailedException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DeepCopyFailedException(){
		super();
	}
	
	public DeepCopyFailedException(String message){
		super(message);
	}
	
	public DeepCopyFailedException(String message, Throwable cause){
		super(message, cause);
	}
}
