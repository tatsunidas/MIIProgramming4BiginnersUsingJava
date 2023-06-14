package com.vis.basic_statements;

/**
 * 
 * @author tatsunidas
 *
 */
public class ForLoopTest {

	public static void main(String[] args) {
		/*
		 * simple for statement
		 */
		int num = 0;
		for(int i=0;i<10;i++) {
			num++;
		}
		System.out.println("iterated："+num);
		
		/*
		 * 1 dimensional array iteration
		 */
		byte d1Pixels[] = {1,2,3,4,5,6,7,8,9};
		for(int i=0;i<d1Pixels.length;i++) {
			System.out.println("pixel val："+d1Pixels[i]);
		}
		
		/*
		 * 2 dimensional array iteration
		 */
		byte d2Pixels[][] = {{1,2,3},{4,5,6},{7,8,9}};
		int hight = d2Pixels.length;
		int width = d2Pixels[0].length;
		for(int h=0;h<hight;h++) {//rows
			for(int w=0;w<width;w++) {//cols
				System.out.println("pixel(2D)"+" "+h+" "+w+" :"+d2Pixels[h][w]);
			}
		}
		
		/*
		 * 3 dimensional array iteration
		 */
		byte d2Pixels2[][] = {{10,20,30},{40,50,60},{70,80,90}};
		byte d3Pixels[][][] = {d2Pixels,d2Pixels2};
		int sliceNum = d3Pixels.length;
		hight = d3Pixels[0].length;
		width = d3Pixels[0][0].length;
		for (int s = 0; s < sliceNum; s++) {// slice
			for (int h = 0; h < hight; h++) { // rows
				for (int w = 0; w < width; w++) { //cols
					System.out.println("pixel(3D)" +" "+s+" "+ h +" "+ w +" :"+ d3Pixels[s][h][w]);
				}
			}
		}
	}

}
