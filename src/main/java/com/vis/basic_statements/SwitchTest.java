package com.vis.basic_statements;

public class SwitchTest {

	public static void main(String[] args) {
		String Type = "CR";
		switch (Type) {
		case "CR": {
			System.out.println("Complete Response");
			break;
		}
		case "PR": {
			System.out.println("Partial Response");
			break;
		}
		case "SD": {
			System.out.println("Stable Disease");
			break;
		}
		case "PD": {
			System.out.println("Progressive Response");
			break;
		}
		default: {
			System.out.println("Not Evaluable");
		}
		}
	}

}
