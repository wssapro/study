package cn.ws.tools;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * <p>
 *	堆排序

 * </p>
 *
 * @author shun
 * @date 2020-06-19 20:17
 */
public class duipaixu
{
	public static void main(String[] args)
	{
		HashMap<Integer, Integer[]> hashMap = new HashMap<>();
		hashMap.put(1,new Integer[]{5,2,3});
		hashMap.put(2,new Integer[]{0,2,3});
		hashMap.put(3,new Integer[]{0,2,3});
		hashMap.put(4,new Integer[]{34,2,3});
		hashMap.put(5,new Integer[]{345,2,3});
		hashMap.put(6,new Integer[]{72,2,3});
		HashMap<Integer, Integer[]> integerHashMap = topUserPackage(hashMap, 5, 0);
		System.out.println(111);
	}
	//寻找前k个最大的数--使用小顶堆
	public static HashMap<Integer, Integer[]> topUserPackage(HashMap<Integer, Integer[]> hashMap, int k, final int type)
	{
		//寻找前k个最小数，因此将小顶堆大小定义为k
		PriorityQueue<StatisticResult> queue = new PriorityQueue<StatisticResult>(k,
				new Comparator<StatisticResult>()
				{
					public int compare(StatisticResult i1, StatisticResult i2)
					{
						return i1.getValue()[type] - i2.getValue()[type];
					}
				});
		int i = 0;
		for (Map.Entry<Integer, Integer[]> entry : hashMap.entrySet())
		{
			if (i < k)
			{
				StatisticResult statisticResult = new StatisticResult(entry.getKey(), entry.getValue());
				queue.offer(statisticResult);
			}
			else
			{
				assert queue.peek() != null;
				if (entry.getValue()[type] > queue.peek().getValue()[type])
				{
					StatisticResult statisticResult = new StatisticResult(entry.getKey(), entry.getValue());
					queue.poll();    //说明堆顶元素（堆中最小元素）一定不属于前k大的数，出堆
					queue.offer(statisticResult);    //当前元素有可能属于前k大，入堆
				}
			}
			i++;
		}
		HashMap<Integer, Integer[]> map = new HashMap<>();
		while (!queue.isEmpty())
		{
			StatisticResult poll = queue.poll();
			map.put(poll.getKey(), poll.getValue());
		}
		return map;
	}

}
class StatisticResult
{
	private Integer key;
	private Integer key_version;
	private Integer[] value;

	public StatisticResult()
	{
	}

	public StatisticResult(Integer key, Integer[] value)
	{
		this.key = key;
		this.value = value;
	}

	public StatisticResult(Integer key, Integer key_version, Integer[] value)
	{
		this.key = key;
		this.key_version = key_version;
		this.value = value;
	}

	public Integer getKey_version()
	{
		return key_version;
	}

	public void setKey_version(Integer key_version)
	{
		this.key_version = key_version;
	}

	public Integer getKey()
	{
		return key;
	}

	public void setKey(Integer key)
	{
		this.key = key;
	}

	public Integer[] getValue()
	{
		return value;
	}

	public void setValue(Integer[] value)
	{
		this.value = value;
	}

}
