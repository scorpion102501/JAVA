package Algorithm;

import java.util.Scanner;

public class A010_Temperature {
	public static void main(String[] args){
		//�ؤ��ഫ�����
		Scanner sc = new Scanner(System.in);
		double tem = sc.nextDouble();
		System.out.printf("%.3f", 5*(tem-32)/9);
	}
}
