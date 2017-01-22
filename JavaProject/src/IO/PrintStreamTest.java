package IO;

import java.io.FileOutputStream;
import java.io.PrintStream;

public class PrintStreamTest {
	public static void main(String[] args){
		try(
			FileOutputStream fos = new FileOutputStream("test.txt");
			PrintStream ps = new PrintStream(fos)){
			
			ps.println("´¶³q¦r¦ê");
			ps.println(new PrintStreamTest());
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
