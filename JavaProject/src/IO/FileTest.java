package IO;
import java.io.File;
import java.io.IOException;

public class FileTest {
	public static void main(String[] args) throws IOException{
		//�H���e���|�إߤ@��File����
		File file = new File(".");
		System.out.println(file.getName());
		System.out.println(file.getParent());
		System.out.println(file.getAbsolutePath());
		System.out.println(file.getAbsoluteFile().getParent());
		
		File tmpFile = File.createTempFile("aaa", ".txt", file);
		tmpFile.deleteOnExit();
		
		File newFile = new File(System.currentTimeMillis()+"");
		System.out.println("newFile����O�_�s�b:" + newFile.exists());
		newFile.createNewFile();
		newFile.mkdir();
		
		String[] fileList = file.list();
		System.out.println("====���e���|�U�Ҧ��ɮ���ܦp�U===");
		for(String fileName : fileList){
			System.out.println(fileName);
		}
		
		File[] roots = File.listRoots();
		System.out.println("====�t�ΩҦ�����|�p�U====");
		for(File root : roots){
			System.out.println(root);
		}
	}
}