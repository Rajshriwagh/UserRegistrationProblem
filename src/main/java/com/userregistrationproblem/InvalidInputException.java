package com.userregistrationproblem;

public class InvalidInputException extends Exception {
	void InvalidInput() throws Exception{
		throw new Exception("Invalid Inputs Detected");
	}
}
