package basic;

public class MultiDArray {
	public static void main(String[] args){
		//3*3Array
		int twoDInt[][] = new int[3][3];
		//2*3*4Array
		int threeDInt[][][] = new int [2][3][4];
		//對稱陣列
		int intArray[][] = new int[2][2];
		//非對稱陣列
		int intArray2[][] = new int[2][];
		intArray2[0] = new int[3];
		intArray2[1] = new int[1];
		
		//isArray()判斷是否為陣列
		int array[][] = {{1,2,3},{4,5,6}};
		System.out.println(array.getClass().isArray());
		//arrayCopy(來源,起始索引,目的,起始索引,複製長度)
		int[] i = {1,2,3,4,5};
		System.arraycopy(i, 1, i, 3, 2);
		//i=1,2,3,2,3
		System.out.print(i[4]);
	}
}
