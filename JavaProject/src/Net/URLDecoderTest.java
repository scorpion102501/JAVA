package Net;

import java.net.URLDecoder;
import java.net.URLEncoder;

public class URLDecoderTest {
	public static void main(String[] args) throws Exception{
		//��Jurlencoded�r��
		//�ഫ���@��r��
		String word = URLDecoder.decode("%E6%88%91%E6%98%AF%E7%A8%8B%E5%BC%8F%E8%A8%AD%E8%A8%88%E5%B8%AB","utf-8");
		System.out.println(word);
		//�@��r���ഫ��urlencoded�r��
		String str = URLEncoder.encode("�ڷR�g�{��","GBK");
		System.out.println(str);
	}
}
