package cn.ws.jdk8.threadTest;

import java.util.HashMap;

/**
 * <p>
 *
 * </p>
 *
 * @author shun
 * @date 2020-06-19 11:05
 */
public class Test
{
	public static void main(String[] args)
	{
		HashMap<String,String>[] nodes = new HashMap[10];
		new Thread(() ->
		{
			HashMap<String,String> map = new HashMap<>();
			map.put("1", "1");
			System.out.println(Thread.currentThread().getName());
			nodes[0] = map;
		}
		).start();
		new Thread(() ->
		{
			HashMap<String,String> map = new HashMap<>();
			map.put("2", "1");
			System.out.println(Thread.currentThread().getName());
			nodes[2]=map;
		}
		).start();
		new Thread(() ->
		{
			HashMap<String,String> map = new HashMap<>();
			map.put("3", "1");
			System.out.println(Thread.currentThread().getName());
			nodes[3]=map;
		}
		).start();
		new Thread(() ->
		{
			HashMap<String,String> map = new HashMap<>();
			map.put("4", "1");
			System.out.println(Thread.currentThread().getName());
			nodes[4]=map;
		}
		).start();

		try
		{
			Thread.sleep(1000);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		System.out.println("a");
	}
}
