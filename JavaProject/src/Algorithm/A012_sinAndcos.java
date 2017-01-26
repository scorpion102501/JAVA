package Algorithm;

import java.util.Scanner;

public class A012_sinAndcos {
	public static void main(String[] args){
		//輸入正整數n(n<360)，輸出n度的正弦和餘弦函數值
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(Math.sin((double)n) + "," + Math.cos((double)n));
	}
}
