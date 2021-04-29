package com.cg.phonebook.exception;

public class UsersupportException extends RuntimeException{
	
 public UsersupportException() {
	 super();
 }
 public UsersupportException(String errMessage) {
	 super(errMessage);
 }
}
