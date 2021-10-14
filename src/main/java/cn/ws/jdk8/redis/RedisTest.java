package cn.ws.jdk8.redis;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayDeque;
import java.util.Date;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * <p>
 *
 * </p>
 *
 * @author shun
 * @date 2020-06-28 15:41
 */
public class RedisTest
{
	public static void main(String[] args) throws ParseException {
		/*RedisUtil redisUtil = new RedisUtil();
		String key = "key";
		redisUtil.zadd(key,10,"1");
		redisUtil.zadd(key,20,"2");
		redisUtil.zadd(key,30,"3");
		redisUtil.zadd(key,40,"4");

		Long zcard = redisUtil.zcard(key);
		Long a = redisUtil.zcount(key,10,20);
		Set<String> zrange = redisUtil.zrange(key, 0, 0);
		Long zrank = redisUtil.zrank(key, "3");
		Long zrem = redisUtil.zrem(key, "3");

		System.out.println("zrank");*/

		ArrayDeque<Object> mDataList = new ArrayDeque<Object>();

		//ConcurrentLinkedQueue<Object> linkedQueue  = new ConcurrentLinkedQueue<Object>();
		//ConcurrentLinkedDeque<Object> linkedDeque  = new ConcurrentLinkedDeque<Object>();
		ConcurrentLinkedQueue<Object> linkedQueue  = new ConcurrentLinkedQueue<Object>();
		ConcurrentLinkedDeque<Object> linkedDeque  = new ConcurrentLinkedDeque<Object>();

		/*long l1 = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			mDataList.offer(i);
		}
		long l2 = System.currentTimeMillis();
		System.out.println(l2-l1);
		for (int i = 0; i < 1000000; i++) {
			linkedQueue.offer(i);
		}
		long l3 = System.currentTimeMillis();
		System.out.println(l3-l2);
		for (int i = 0; i < 1000000; i++) {
			linkedDeque.offer(i);
		}
		long l4 = System.currentTimeMillis();
		System.out.println(l4-l3);
*/

		String a = "2021-03-09 00:01:00";
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date parse = format1.parse(a);
		SimpleDateFormat format = new SimpleDateFormat("HH");
		String hour = format.format(parse);

		System.out.println(Integer.parseInt(hour));


	}
}
