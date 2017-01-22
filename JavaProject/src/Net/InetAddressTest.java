package Net;

import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {
	public static void main(String[] args) throws IOException{
		InetAddress ip4 = InetAddress.getByName("www.crazyit.org");
		//�i�_��F
		System.out.println("crazyit�i�_��F:" + ip4.isReachable(2000));
		//��oIP��}
		System.out.println(ip4.getHostAddress());
		//��o��lIP��}
		InetAddress local = InetAddress.getByAddress(new byte[]{127,0,0,1});
		System.out.println("�����i�_��F:"+local.isReachable(2000));
		System.out.println(local.getCanonicalHostName());
	}
}
