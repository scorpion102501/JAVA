package IO;

import java.io.FileOutputStream;
import java.io.PrintStream;

public class RedirectOut {
	public static void main(String[] args){
		try(
			PrintStream ps = new PrintStream(new FileOutputStream("out.txt"))){
			System.setOut(ps);
			System.out.println("´¶³q¦r¦ê");
			System.out.println(new RedirectOut());
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
