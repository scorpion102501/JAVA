package Algorithm;

import java.util.Scanner;

public class A007_SwitchVariable1 {
	public static void main(String[] args){
		//交換兩變數
		int a, b, t;
		Scanner sc = new Scanner(System.in);
		a = sc.nextInt();
		b = sc.nextInt();
		t = a;
		a = b;
		b = t;
		System.out.println(a+ ","+ b);
	}
}
