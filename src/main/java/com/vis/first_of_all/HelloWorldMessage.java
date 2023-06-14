package com.vis.first_of_all;

public class HelloWorldMessage {
	
	/*
	 * main method is a special method.
	 * java applications always start from.
	 */
	public static void main(String[] args) {
		message("Hello World !");
	}
	
	/**
	 * This method will output messages on console.
	 * @param msg : String means mojiretsu in Japanese, should make around with double quotations.
	 */
	public static void message(String msg) {
		System.out.println(msg);
	}

}
