package net.codingartist.algo_ds.objects;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Objects;

public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5690122993175840585L;
	private String userID;
	private char[] password;//If we store a password as a String, it stays in the pool in memory until being garbage collected.
	private final LocalDateTime createdAt;
	
	public User(String userID, char[] password) {
		this.userID = Objects.requireNonNull(userID);
		this.password = Objects.requireNonNull(password);
		this.createdAt = LocalDateTime.now();
	}
	
	public String getUserID() {
		return this.userID;
	}
	
	public char[] getPassword() {
		return this.password;
	}
	
	public void setUserID(String userID) {
		this.userID = userID;
	}
	
	public void setPassword(char[] password) {
		this.password = password;
	}
	
	public LocalDateTime getCreatedAt() {
		return createdAt; //LocalDateTime is immutable
	}
	
	public boolean isPasswordCorrect(char[] password) {
		if(password == null) {
			throw new NullPointerException("password is null.");
		}
		return Arrays.compare(this.password, password) == 0;
	}
	
	public boolean isUserIDCorrect(String userID) {
		if(userID == null) {
			throw new NullPointerException("userID is null.");
		}
		return this.userID.equals(userID);
	}
	
	@Override
	public int hashCode() {
		return userID.hashCode();
	}
	
}
