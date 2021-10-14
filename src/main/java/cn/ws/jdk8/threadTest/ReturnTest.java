package cn.ws.jdk8.threadTest;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *
 * </p>
 *
 * @author shun
 * @date 2020-06-19 13:43
 */
public class ReturnTest
{
	public static void main(String[] args)
	{
		ReturnTest returnTest = new ReturnTest();
		Map map = new HashMap();
		map.put(1,1);
		returnTest.a(map);
		System.out.println(map.size());
	}
	private void a(Map map){
		map.put(2,2);
	}
}
