package Algorithm;

import java.util.Scanner;

public class A004_AaddB {
	public static void main(String[] args){
		//輸入兩整數a,b相加
		System.out.println("輸入兩整數相加(以空格分隔)");
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		System.out.println(a+b);
	}
}
