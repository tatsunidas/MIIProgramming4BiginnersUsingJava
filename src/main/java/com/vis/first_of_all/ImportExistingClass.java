package com.vis.first_of_all;

import javax.swing.JFrame;//import statement 

public class ImportExistingClass {

	public static void main(String[] args) {
		/*
		 * load existing class, e.g., JFrame.
		 * JFrame is a graphical user interface component like an application windows.
		 */
		javax.swing.JFrame frame = new javax.swing.JFrame("Your View");
		frame.setLocation(200, 200);
		frame.setVisible(true);
		
		/*
		 * you can following too, with "import path.to.class" statements.
		 */
		@SuppressWarnings("unused")//Don't worry about this annotation.
		JFrame frame_ = new JFrame("Your View");
		
		/*
		 * you can call ImageJ from this code. How ?? Just simply coding... 
		 * ImageJ ij = new ImageJ();//with import ij.ImageJ;
		 */
	}

}
