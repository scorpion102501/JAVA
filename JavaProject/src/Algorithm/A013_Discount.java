package Algorithm;

import java.util.Scanner;

public class A013_Discount {
	public static void main(String[] args){
		//一件衣服95元，若消費滿300元，可以打85折。
		//輸入購買衣服件數，輸出需要支付金額，保留兩位數
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), m = n * 95;
		if(m >= 300)
			m*=0.85;
		System.out.println(m);
	}
}
