package Algorithm;

import java.util.Scanner;

public class A013_Discount {
	public static void main(String[] args){
		//�@���A95���A�Y���O��300���A�i�H��85��C
		//��J�ʶR��A��ơA��X�ݭn��I���B�A�O�d����
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), m = n * 95;
		if(m >= 300)
			m*=0.85;
		System.out.println(m);
	}
}
