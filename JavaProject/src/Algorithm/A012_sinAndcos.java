package Algorithm;

import java.util.Scanner;

public class A012_sinAndcos {
	public static void main(String[] args){
		//��J�����n(n<360)�A��Xn�ת������M�l����ƭ�
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(Math.sin((double)n) + "," + Math.cos((double)n));
	}
}
