package Algorithm;

import java.util.Scanner;

public class A005_CalcCylinderSurfaceArea {
	public static void main(String[] args){
		//��J�b�|r�M��h�A��X��W�骺�����n
		//�p���W�魱�n:�����n*2+�����n
		final double pi = 3.1415926;
		Scanner sc = new Scanner(System.in);
		double r=sc.nextDouble(), h=sc.nextDouble(), s1, s2, s;
		s1 = pi*r*r;
		s2 = 2*pi*r*h;
		s = s1*2.0+s2;
		System.out.printf("%.3f",s);
	}
}