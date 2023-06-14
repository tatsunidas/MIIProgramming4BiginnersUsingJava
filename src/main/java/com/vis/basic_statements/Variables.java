package com.vis.basic_statements;

/**
 * 
 * @author tatsunidas
 *
 */
public class Variables {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		/*
		 * number
		 */
		byte byteValue = 127;
		short shortValue = 32767;
		int intValue = 2147483647;// java default.
		long longValue = 9223372036854775807L;// adding l or L at end of value to distinguish int type.

		/*
		 * Real and floating point numbers
		 */
		float floatValue = 1.0f;// adding f or F at end of value to distinguish double type.
		double doubleValue = 2.0d;// java default, 2.0d or 2.0D are also OK.

		/*
		 * Character（16-bit）
		 */
		char charValue = 'a';// should be use single quote !
		char charValue2 = 97;// you can input hex number directly.
		System.out.println(Integer.toHexString(charValue));
		System.out.println((int)charValue);

		/*
		 * true or false
		 */
		boolean bool = true;// true or false only.

		/*
		 * String
		 */
		String moji = "何かの文字列";

		/*
		 * overflow
		 * 
		 * When the range of the type is exceeded, it circles back to the smallest (or largest) value.
		 */
		byte byteValue2 = (byte) 128;//byte range : -128 ~ 127
		System.out.println(byteValue2);
	}

}
