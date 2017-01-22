package IO;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterTest {
	public static void main(String[] args){
		try(FileWriter fw = new FileWriter("poem.txt"))
		{
			fw.write("錦瑟 - 李商隱\r\n");
			fw.write("錦瑟無端五十弦，一弦一柱思華年。\r\n");
			fw.write("莊生曉夢迷蝴蝶，望帝春心託杜鵑。\r\n");
			fw.write("滄海月明珠無淚，藍田日暖玉生煙。\r\n");
			fw.write("此情可待成追憶，只是當時已惘然。\r\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
