package Algorithm;

import java.util.Scanner;

public class A008_ChickenAndRabbit {
	public static void main(String[] args){
		//���ߦPŢ
		//�w�����ߪ��`�ƶq��n �`�}�Ƭ�m
		//��Jn�Mm��X���M�ߪ��ƶq
		//�p�G�L�ѫh��XNo Answer
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