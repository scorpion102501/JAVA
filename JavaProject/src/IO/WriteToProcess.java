package IO;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class WriteToProcess {
	public static void main(String[] args) throws IOException{
		Process p = Runtime.getRuntime().exec("java ReadStandard");
		try(
			PrintStream ps = new PrintStream(p.getOutputStream()))
		{
			ps.println("���q�r��");
			ps.println(new WriteToProcess());
		}
	}
}

