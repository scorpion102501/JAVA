package Algorithm;

import java.util.Scanner;

public class A006_ReverseNumber {
	public static void main(String[] args){
		//�T��Ƥ���
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(""+ n%10+ n/10%10+ n/100);
	}
}