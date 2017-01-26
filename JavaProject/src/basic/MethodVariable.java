package basic;

public class MethodVariable {
	int i = 10;
	public static void main(String[] args){
		int i = 11;
		new MethodVariable().geti(i);
		System.out.println("i = " + i);
		System.out.println("new MethodVariable().i = " + new MethodVariable().i);
	}
	void geti(int i){
		System.out.println("i = " + i);
		System.out.println("this.i = " + this.i);
	}
}
