package com.vis.basic_statements;

import java.util.Scanner;

public class WhileLoopTest {

	public static void main(String[] args) {
//		loop1();
		loop2();
//		doWhileLoop();
	}

	static void loop1() {
		/*
		 * looping until i up to 5.
		 */
		int i = 0;
		while (i < 5) {
			System.out.println("Now looping!!! " + (++i));
		}

		/*
		 * looping until num down to -1
		 */
//		int num = 7;
//		do{
//		  System.out.println("number = " + num);
//		  num -= 1;
//		}while(num > 0);
	}

	static void loop2() {
		/*
		 * Loop until input characters match Type directly into the Console at the
		 * bottom of the screen and press Enter.
		 */
		try (Scanner input = new Scanner(System.in)) {
			String answer = input.next();
			while (!answer.equals("stop")) {
				System.out.println(answer);
				answer = input.next();
			}
			System.out.println("goodbye!");
		}
	}

	static void doWhileLoop() {
		/*
		 * If you always process once and then continue the loop, 
		 * you can use the do-while statement.
		 */
		int num = 5;
		do {
			System.out.println("number = "+num+" (in do-while)");
			num -= 1;//same as : num = num - 1;
		}while(num > 0);
		
	}

}
