package IO;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class KeyInTest {
	public static void main(String[] args){
		try(
			InputStreamReader reader = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(reader))
		{
			String line = null;
			while((line = br.readLine()) != null){
				if(line.equals("exit")){
					System.exit(1);
				}
				System.out.println("輸入內容為:" + line);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
