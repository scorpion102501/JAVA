package basic;

public class Variable {
	public static void main(String[] args){
		/*char*/
		char c1 = 'J';	
		char c2 = '��';
		char c3 = 74;	//ASCII(65)�����OJ
		char[] cArray;
		char n = '\0';	//�Ŧr��
		/*String*/
		String str1 = "string";
		String str2 = "str"+"ing";
		String str3 = "number" + 1;
		/*byte*/ 
		byte b1 = 1;
		byte b2 = 'J';		//J��ASCII = 74
		byte b3 = '1';		//1��ASCII = 49
		byte b4 = 127;
		byte b5 = 052;		//42
		byte b6 = 0x1F;		//31
		byte b7 = 0b1110;	//14
		byte[] bArray;
		/*short*/
		short s1 = 1;
		short s2 = 'J';
		short[] sArray;
		short s3 = 1_000;
		/*int*/
		int i1 = 17;
		int[] iArray;
		int i2 = 52_000;
		/*long*/
		long l1 = 5;
		long l2 = 'J';
		long l3 = 1L;
		long[] lArray;
		long l4 = 1_000_000_000;
		/*float*/
		float f1 = 1;		//f1=1.0
		float f2 = 'J';		//f2=74.0
		float f3 = 3.14F;	//3.14�w�]��double���A�n�[�WF�૬��float���A
		float[] fArray;
		final float pi = 3.1415926f;
		/*double*/
		double d1 = 1;	//d1=1.0;
		double d2 = 1.1f;
		double d3 = 1.1;
		double[] dArray;
		final double PI = 3.1415926;
		/*boolean*/
		boolean bo1 = true;
		boolean[] boArray;
		//���t�ഫ
		int ii =1;
		double dd = 0;
		dd = ii;
		//�j���ഫ
		ii = (int)dd;
	}
}