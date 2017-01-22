package IO;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterTest {
	public static void main(String[] args){
		try(FileWriter fw = new FileWriter("poem.txt"))
		{
			fw.write("�A�� - ������\r\n");
			fw.write("�A��L�ݤ��Q���A�@���@�W��ئ~�C\r\n");
			fw.write("���;�ڰg�����A��ҬK�߰U���Y�C\r\n");
			fw.write("�ɮ�����]�L�\�A�ťФ�x�ɥͷϡC\r\n");
			fw.write("�����i�ݦ��l�СA�u�O��ɤw���M�C\r\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
