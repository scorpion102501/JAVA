package Algorithm;

import java.text.DecimalFormat;

public class A002_Calc8except5 {
	public static void main(String[] args){
		//�p��ÿ�X8/5���ȡA�O�d�p���I��1��
		DecimalFormat df = new DecimalFormat("#.#");
		double x = 8d/5d;
		System.out.println(df.format(x));
	}
}