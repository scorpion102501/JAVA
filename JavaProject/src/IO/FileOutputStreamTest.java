package IO;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileOutputStreamTest {
	public static void main(String[] args){
		try(
			FileInputStream fis = 
			new FileInputStream("C:\\Users\\Scor\\Desktop\\JavaWorkspaceBlog\\JavaProject\\src\\IO\\FileOutputStreamTest.java");
			FileOutputStream fos = new FileOutputStream("newFile.txt")){
			byte[] bbuf = new byte[32];
			int hasRead = 0;
			
			while((hasRead = fis.read(bbuf)) > 0){
				fos.write(bbuf, 0, hasRead);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
