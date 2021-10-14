package cn.ws.tools;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author shun
 * @date 2020-10-30 17:36
 */
public class HttpArrea {

	public static void main(String[] args) throws UnknownHostException {
//用 getLocalHost() 方法创建的InetAddress的对象
		InetAddress address = InetAddress.getLocalHost();
		System.out.println(address.getHostName());//主机名
		System.out.println(address.getCanonicalHostName());//主机别名
		System.out.println(address.getHostAddress());//获取IP地址
		System.out.println("===============");
	}

}
