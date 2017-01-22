package IO;

import java.io.FileReader;
import java.io.PushbackReader;

public class PushbackTest {
	public static void main(String[] args){
		//cant print all code
		String dir = "C:\\Users\\Scor\\Desktop\\JavaWorkspaceBlog\\JavaProject\\src\\IO\\";
		try(
			PushbackReader pr = new PushbackReader(new FileReader(dir + "PushbackTest.java"), 64))
		{
			char[] buf = new char[32];
			String lastContent = "";
			int hasRead = 0;
			while((hasRead = pr.read(buf)) > 0){
				String content = new String(buf, 0, hasRead);
				int targetIndex = 0;
				if((targetIndex = (lastContent + content).indexOf("new PushbackReader")) > 0){
					pr.unread((lastContent + content).toCharArray());
					
					if(targetIndex > 32){
						buf = new char[targetIndex];
					}
					pr.read(buf, 0, targetIndex);
					System.out.print(new String(buf, 0, targetIndex));
					System.exit(0);
				}else{
					System.out.println(lastContent);
					lastContent = content;
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}