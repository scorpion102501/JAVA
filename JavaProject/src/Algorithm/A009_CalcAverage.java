package Algorithm;

import java.util.Scanner;

public class A009_CalcAverage {
	public static void main (String[] args){
		//�p��X�T��ƪ������ȡA�O�d�p���I�T���
		Scanner sc = new Scanner(System.in);
		double a=sc.nextDouble(),b=sc.nextDouble(),c=sc.nextDouble();
		System.out.printf("%.3f",(a+b+c)/3);
	}
}