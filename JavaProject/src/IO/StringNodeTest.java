package IO;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

public class StringNodeTest {
	public static void main(String[] args){
		String src = "�q���Ѱ_�A���@�ө��֪��H\n"
				+ "�����A�A���A�P�C�@��\n"
				+ "�ڦ��@�ɩФl�A���¤j���A�K�x��}\n"
				+ "�q���Ѱ_�A�M�C�@�ӿˤH�q�T\n"
				+ "�i�D�L�̧ڪ�����\n";
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
			sw.write("���@�Ӭ��R���s�@�ɡA\n");
			sw.write("�o�b���赥�ڡA\n");
			sw.write("���ئ��ѯu���Ĥl�A\n");
			sw.write("�٦��h�Q���s��\n");
			System.out.println("------�U���Osw�r��`�I�̪����e-----");
			System.out.println(sw.toString());
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
