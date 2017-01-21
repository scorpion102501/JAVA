package IO;
import java.io.File;
import java.io.IOException;

public class FileTest {
	public static void main(String[] args) throws IOException{
		//以當前路徑建立一個File物件
		File file = new File(".");
		System.out.println(file.getName());
		System.out.println(file.getParent());
		System.out.println(file.getAbsolutePath());
		System.out.println(file.getAbsoluteFile().getParent());
		
		File tmpFile = File.createTempFile("aaa", ".txt", file);
		tmpFile.deleteOnExit();
		
		File newFile = new File(System.currentTimeMillis()+"");
		System.out.println("newFile物件是否存在:" + newFile.exists());
		newFile.createNewFile();
		newFile.mkdir();
		
		String[] fileList = file.list();
		System.out.println("====當前路徑下所有檔案顯示如下===");
		for(String fileName : fileList){
			System.out.println(fileName);
		}
		
		File[] roots = File.listRoots();
		System.out.println("====系統所有跟路徑如下====");
		for(File root : roots){
			System.out.println(root);
		}
	}
}
