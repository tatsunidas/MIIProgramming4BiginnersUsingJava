package com.vis.first_of_all;

/**
 * 画像間演算では、画像同士を足したり引いたり、
 * ピクセルを他の値に変換したりしています。
 * 例えば、CT値、白黒反転画像、その他の計算画像など
 * 
 * 一般的な四則演算
 * int ans = 10 + 5;
 * System.out.println("+ :"+ans);
 * ans = 10 - 5;
 * System.out.println("- :"+ans);
 * ans = 10 * 5;
 * System.out.println("* :"+ans);
 * ans = 10 / 5;
 * System.out.println("/ :"+ans);
 * ans = 10 % 5;
 * System.out.println("%(余り) :"+ans);
 * 
 * テキストの演算
 * String text = "abc"+"def";
 * System.out.println("String :"+text);
 * 
 * 代入演算
 * int a = 3;
 * int b = 6;
 * a = a + b;//計算結果を代入しなおす
 * System.out.println("代入演算1 :"+a);
 * int c = 0;
 * c++;//c--もOK
 * System.out.println("代入演算2 :"+c);
 * 
 * この他にもMathクラスを利用して
 * 対数、三角関数、平方根などの算術演算もできます。
 * 
 * データタイプの異なる変数間の計算
 * レンジ小→大：そのまま計算可能
 * レンジ大→小： 変数の前に(データ型)を追記して値を変換（キャスト）する
 * 
 * int data1 = 1;
 * int data2 = 2;
 * double data3 = data1 + data2;
 * System.out.println("キャストなし："+data3);
 * 
 * double data11 = 1.0d;
 * double data22 = 2.5d;
 * int data33 = (int)data11 + (int)data22;
 * 
 * 整数にキャストするときは小数点以下は切り捨てられるので注意
 * System.out.println("キャストあり(3.5にはならない)："+data33);
 * 
 * @author tatsunidas
 *
 */
public class Calculation {

	public static void main(String[] args) {
		int sum = goukei(250, 200);
		int zeikomi = taxIncludedPrice(sum, 0.1f);
		System.out.println("Your total payment : "+zeikomi + " yen.");
	}
	
	static int goukei(int banana, int milk) {
		int sum = banana + milk;
		return sum;
	}
	
	static int taxIncludedPrice(int goukei, float taxRate) {
		int payment = (int) (goukei * (1f+taxRate));//do you remember casting ?
		return payment;
	}
	
	static void mathMoreAndMore() {
		/*
		 * you can check methods in Math class.
		 */
		System.out.println(Math.PI);
	}
	
	/**
	 * 
	 * @param reserveAmountPerYear:tumitate-gaku
	 * @param annualInterestRate:ri-ritu
	 * @param years:nensu
	 */
	static void compoundInterest(int reserveAmountPerYear, float annualInterestRate, int years) {
		
		/*
		 * sougaku = reserveAmountPerYear * ((1 + annualInterestRate)^years - 1) / annualInterestRate
		 */
		
		//which is correct ?
		
//		int sougaku0 = (int) (reserveAmountPerYear * (Math.pow((1+annualInterestRate), years) -1 ) / annualInterestRate);
//		int sougaku1 = (int) (reserveAmountPerYear * (Math.pow(years, (1+annualInterestRate)) -1 ) / annualInterestRate);
//		int sougaku2 = (int) (reserveAmountPerYear * (Math.sqrt((1+annualInterestRate), years) -1 ) / annualInterestRate);
	}

}
