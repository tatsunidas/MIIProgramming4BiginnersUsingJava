package com.vis.basic_statements;

import java.util.Random;

public class If_ElseTest {

	public static void main(String[] args) {
		// simply
		int num = 10;
		if(num > 5) {
			System.out.println("num is larger than 5.");
		}
		
		/*
		 * if-else
		 */
		if(num > 10) {
			//do something
		}else {
			System.out.println("num is smaller than 10");
		}
		
		/*
		 * add multiple else rule.
		 */
		if(num > 10) {
			//do something
		}else if(num > 3) {
			System.out.println("num is larger than 3");
		}else if(num > 0) {
			System.out.println("num is larger than 0");
		}else {
			// do something when no matching.
			System.out.println("num is smaller than 1");
		}
		
		/*
		 * if combination
		 */
		if(num > 5) {
			if(num==10) {
				System.out.println("num=10");
			}
		}
		
		/*
		 * combination with for-statement 
		 */
		int pixels[] = new int[9];
		for(int i=0;i<9;i++) {
			Random rand = new Random();
			pixels[i] = rand.nextInt(200);//something like HU value.
		}
		
		/*
		 * 30 HU < pixel <= 190HU fat pixel intensity
		 */
		for(int i=0;i<pixels.length;i++) {
			if(30<pixels[i] && pixels[i]<=190) {
				System.out.println("Fat pixel "+i+" "+pixels[i]);
			}
		}
	}

}
