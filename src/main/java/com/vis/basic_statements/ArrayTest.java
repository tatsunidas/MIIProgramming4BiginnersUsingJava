package com.vis.basic_statements;

import java.util.ArrayList;
import java.util.OptionalInt;

/**
 * 
 * @author tatsunidas
 *
 */
public class ArrayTest {

	public static void main(String[] args) {
		// 1-dimensional arrays
		byte d1MatrixRow0[] = { 1, 2, 3 };
		byte d1MatrixRow1[] = { 4, 5, 6 };
		byte d1MatrixRow2[] = { 7, 8, 9 };

		/*
		 * データ型は変えられます
		 */
//		int d1MatrixRow0[] = {1,2,3};//e.g,
//		double d1MatrixRow0[] = {1.0,2.0,3.0};//e.g,
//		Object anyData[] = {data1,data2,data3};//e.g,

		// 2-dimensional array
		/*
		 * add rows from upper left corner
		 */
		byte d2Matrix[][] = new byte[3][3];// [rows][cols]
		d2Matrix[0] = d1MatrixRow0;
		d2Matrix[1] = d1MatrixRow1;
		d2Matrix[2] = d1MatrixRow2;

		/*
		 * または 次のように書くこともできます
		 */
//		byte d2Matrix[][] = {{1,2,3},{4,5,6},{7,8,9}};

		// check
		System.out.println("values in array");
		System.out.println(d2Matrix[0][0]);
		System.out.println(d2Matrix[0][1]);
		System.out.println(d2Matrix[0][2]);
		System.out.println(d2Matrix[1][0]);
		System.out.println(d2Matrix[1][1]);
		System.out.println(d2Matrix[1][2]);
		System.out.println(d2Matrix[2][0]);
		System.out.println(d2Matrix[2][1]);
		System.out.println(d2Matrix[2][2]);

		// 3D array : Stack(Series) images
		byte d2Matrix2[][] = {{10,20,30},{40,50,60},{70,80,90}};//to add 2d array.
		// create 3d array
		byte d3Matrix[][][] = { d2Matrix, d2Matrix2 };

		// check
		/*
		 * [slice][row][column]
		 */
		System.out.println("3d values");
		System.out.println(d3Matrix[0][0][0]);
		System.out.println(d3Matrix[1][0][0]);

		/*
		 * Although the above way of writing is still usable, 
		 * recently we have been using ArrayList. 
		 * ArrayList makes it easy to compare elements and get the largest/smallest number. 
		 * Here, in ArrayList, use the Byte class as generics to handle bytes.
		 */
		ArrayList<Byte> d1Array = new ArrayList<Byte>();
		d1Array.add((byte) 1);
		d1Array.add((byte) 2);
		d1Array.add((byte) 3);
		// ...continue
		
		OptionalInt res = d1Array.stream().mapToInt(x-> (int)x).max();
		System.out.println("Max value is : " + res.orElse(-1));

		/*
		 * 2d array created by nesting ArrayList
		 */
		ArrayList<ArrayList<Byte>> d2Array = new ArrayList<ArrayList<Byte>>();
		d2Array.add(d1Array);
		// ...continue

		/*
		 * and more dimension...(for 3d array)
		 */
		ArrayList<ArrayList<ArrayList<Byte>>> d3Array = new ArrayList<ArrayList<ArrayList<Byte>>>();
		d3Array.add(d2Array);

		/*
		 * get values
		 */
		System.out.println("Get values using ArrayList");
		System.out.println(d1Array.get(0));// 1D
		System.out.println(d2Array.get(0).get(0));// 2D
		System.out.println(d3Array.get(0).get(0).get(0));// 3D
	}

}
