package IO;

import java.util.Scanner;
import java.io.FileInputStream;

public class RedirectIn {
	public static void main(String[] args){
		String dir = "C:\\Users\\Scor\\Desktop\\JavaWorkspaceBlog\\JavaProject\\src\\IO\\";
		try(
			FileInputStream fis = new FileInputStream(dir + "RedirectIn.java"))
		{
			System.setIn(fis);
			Scanner sc = new Scanner(System.in);
			sc.useDelimiter("\n");
			while(sc.hasNext()){
				System.out.println("��L��J���O:"+sc.next());
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
