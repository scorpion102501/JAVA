package IO;

import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest {
	public static void main(String[] args) throws IOException{
		try(FileReader fr = new FileReader("C:\\Users\\Scor\\Desktop\\JavaWorkspaceBlog\\JavaProject\\src\\IO\\FileReaderTest.java")){
			char[] cbuf = new char[32];
			int hasRead = 0;
			while((hasRead = fr.read(cbuf))>0){
				System.out.print(new String(cbuf, 0, hasRead));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
