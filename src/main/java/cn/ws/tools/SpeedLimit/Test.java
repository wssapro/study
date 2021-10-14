package cn.ws.tools.SpeedLimit;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;

/**
 * @author shun
 * @date 2021-03-26 20:13
 */
public class Test {
	public static void main(String[] args) throws Exception {

		//String redirectUrl = getRedirectUrl("http://tracking.angelmediahk.com/tl?a=17&o=4263");
		//
		//System.out.println(redirectUrl);
		//System.out.println(URLEncoder.encode("ivr#2021031517854524524#1#5425562", "UTF8"));
		//int randomWaitime = getRandomWaitime(10,10);
		//System.out.println(randomWaitime);
		//testSpeedLimiter();
		String baseStr = "0123456789";

		baseStr = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		baseStr = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

		for (int i = 0; i < 10; i++) {

			System.out.println(getRandomStr(baseStr, 10));
		}
	}

	public static String getRandomStr(String baseStr, int len)
	{
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < len; i++)
		{
			int rand = (int) (Math.random() * baseStr.length());
			result.append(baseStr.charAt(rand));
		}
		return result.toString();
	}
	private static String getRedirectUrl(String path) throws Exception {
		HttpURLConnection conn = (HttpURLConnection) new URL(path)
				.openConnection();
		conn.setInstanceFollowRedirects(false);
		conn.setConnectTimeout(5000);
		return conn.getHeaderField("Location");
	}
	public static int getRandomWaitime(int min,int max)
	{
		Random random = new Random();
		int i = random.nextInt(max);
		return random.nextInt(max) % (max - min + 1) + min;
	}
	public static void  testSpeedLimiter()
	{
		String resource = "myresource";
		SpeedLimiter<String> test = new SpeedLimiter<String>(50, 1000, resource);
		TestSpeedLimitedThread<String> testThread1 = new TestSpeedLimitedThread<String>(test);
		testThread1.start();
		TestSpeedLimitedThread<String> testThread2 = new TestSpeedLimitedThread<String>(test);
		testThread2.start();
		TestSpeedLimitedThread<String> testThread3 = new TestSpeedLimitedThread<String>(test);
		testThread3.start();

		try {
			testThread1.join();
			testThread2.join();
			testThread3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
