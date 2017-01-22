package IO;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

public class StringNodeTest {
	public static void main(String[] args){
		String src = "從明天起，做一個幸福的人\n"
				+ "餵馬，劈材，周遊世界\n"
				+ "我有一棟房子，面朝大海，春暖花開\n"
				+ "從明天起，和每一個親人通訊\n"
				+ "告訴他們我的幸福\n";
		char [] buff = new char[32];
		int hasRead = 0;
		
		try(
			StringReader sr = new StringReader(src))
		{
			while((hasRead = sr.read(buff)) > 0){
				System.out.print(new String(buff ,0 ,hasRead));
			}
		}catch(IOException e){
			e.printStackTrace();
		}
		
		try(
			StringWriter sw = new StringWriter())
		{
			sw.write("有一個美麗的新世界，\n");
			sw.write("她在遠方等我，\n");
			sw.write("那裏有天真的孩子，\n");
			sw.write("還有姑娘的酒窩\n");
			System.out.println("------下面是sw字串節點裡的內容-----");
			System.out.println(sw.toString());
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
