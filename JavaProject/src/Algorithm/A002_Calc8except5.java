package Algorithm;

import java.text.DecimalFormat;

public class A002_Calc8except5 {
	public static void main(String[] args){
		//計算並輸出8/5的值，保留小數點後1位
		DecimalFormat df = new DecimalFormat("#.#");
		double x = 8d/5d;
		System.out.println(df.format(x));
	}
}
