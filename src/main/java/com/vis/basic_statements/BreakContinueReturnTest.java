package com.vis.basic_statements;

/**
 * 
 * @author tatsunidas
 *
 */
public class BreakContinueReturnTest {

	public static void main(String[] args) {
		breakTest();
		continueTest();
		returnTest();
	}

	static void breakTest() {
		/*
		 * If you write "break", the process stops in the process of a control statement
		 * and moves on to the next code
		 */
		for (int i = 0; i < 10; i++) {
			if (i == 7) {
				System.out.println("break at "+i);
				break;
			}
		}
	}

	static void continueTest() {
		/*
		 * "continue" will skip middle processes.
		 */
		int skip = 5;
		for(int i=0;i<10;i++) {
			if(i==skip) {
				System.out.println(i+" skipped");
				continue;
			}
			System.out.println("Now processing "+i);
		}
	}

	static void returnTest() {
		int num = 0;
		for(int i=0;i<10;i++) {
			if(i==7) {
				System.out.println("return, because i was "+i);
				return;
			}
			num++;
		}
		/*
		 * following sysout is never executed
		 */
		System.out.println("number of iteration was "+num);
	}
	
	static int returnTest2() {
		/*
		 * if you want return something value,
		 * you can do.
		 */
		int num = 7;
		for(int i=0;i<10;i++) {
			if(i==num) {
				System.out.println("return, because i was "+i);
				return i;
			}
		}
		return -1;//fail safe.
	}
}
