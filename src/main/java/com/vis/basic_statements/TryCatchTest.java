package com.vis.basic_statements;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TryCatchTest {

	public static void main(String[] args) {
//		tryCatch();
//		tryCatchFinally();
//		tryWithResource();
	}
	
	static void tryCatch() {
		File file = new File("dammy.txt");
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String text;
			while ((text = br.readLine()) != null) {
				System.out.println(text);
			}
			br.close();
			fr.close();
		}catch (Exception e) {
			// handle exception
			// you will catch "java.io.FileNotFoundException"
			System.out.println(e.getClass().getCanonicalName());
			System.out.println(e.getMessage());
		}
	}
	
	static void tryCatchFinally() {
		File file = new File("dammy.txt");
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			String text;
			while ((text = br.readLine()) != null) {
				System.out.println(text);
			}
		}catch (Exception e) {
			// handle exception
			// you will catch "java.io.FileNotFoundException"
			System.out.println(e.getClass().getCanonicalName());
			System.out.println(e.getMessage());
		}finally {
			/*
			 * It is always executed after try-catch is executed.
			 */
			if(br != null) {
				try {
					br.close();
				}catch (Exception e) {
					// handle exception
				}
			}
			if(fr != null) {
				try {
					fr.close();
				}catch (Exception e) {
					// handle exception
				}
			}
			System.out.println("Finally Block Executed !");
		}
	}
	
	static void tryWithResource() {
		File file = new File("dammy.txt");
		try (
				FileReader fr = new FileReader(file);//autoclosable interface
				BufferedReader br = new BufferedReader(fr);//autoclosable interface
			 )
		{
			String text;
			while ((text = br.readLine()) != null) {
				System.out.println(text);
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getClass().getCanonicalName());
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getClass().getCanonicalName());
			System.out.println(e.getMessage());
		}
		//The finnally statement can be omitted (you can also write finally block).
		//fr and br were close automatically.
	}

}
