package Algorithm;

import java.util.Scanner;

public class A008_ChickenAndRabbit {
	public static void main(String[] args){
		//雞兔同籠
		//已知雞兔的總數量為n 總腳數為m
		//輸入n和m輸出雞和兔的數量
		//如果無解則輸出No Answer
		Scanner sc = new Scanner(System.in);
		int a, b, n=sc.nextInt(), m=sc.nextInt();
		//a + b = n
		//2a + 4b = m
		//a = (4n-m)/2
		//b = n - a
		a = (4*n-m)/2;
		b = n - a;
		if(m % 2 == 1|| a < 0|| b < 0)
			System.out.println("No Answer!!");
		else
			System.out.println(a + "," +b);
	}
}
