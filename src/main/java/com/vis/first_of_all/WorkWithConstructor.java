package com.vis.first_of_all;

public class WorkWithConstructor {

	public static void main(String[] args) {
		// create instance of this class.
		WorkWithConstructor constructor = new WorkWithConstructor();
		// execute method from constructor
		constructor.hello();
	}
	
	// constructor, method for loading class as an instance.
	public WorkWithConstructor() {
		//here, do something when initialize/load this instance.
	}
	
	public void hello() {
		System.out.println("Hello ! Constructor !");
	}
	
}
