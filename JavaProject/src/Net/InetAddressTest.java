package Net;

import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {
	public static void main(String[] args) throws IOException{
		InetAddress ip4 = InetAddress.getByName("www.crazyit.org");
		//可否到達
		System.out.println("crazyit可否到達:" + ip4.isReachable(2000));
		//獲得IP位址
		System.out.println(ip4.getHostAddress());
		//獲得原始IP位址
		InetAddress local = InetAddress.getByAddress(new byte[]{127,0,0,1});
		System.out.println("本機可否到達:"+local.isReachable(2000));
		System.out.println(local.getCanonicalHostName());
	}
}
