package cn.ws.tools;

/**
 * <p>
 *
 * </p>
 *
 * @author shun
 * @date 2020-06-10 14:01
 */
public class StringSpeed
{
	public static void main(String[] args)
	{

		String str = "null," +
				"11728102,11728145,11728228,11729198,11729653,11731334,11732145," +
				"11728102,11728145,11728228,11729198,11729653,11731334,11732145," +
				"11728102,18888888,11728228,11729198,11729653,11731334,11732145," +
				"19787836";
		str = "null,19787836";
		// 需要删除时间节点
		int timeNode = (int) (System.currentTimeMillis() / 1000
				- (30 * 24 * 60 * 60) - 1577808000);

		/*long la1 = System.currentTimeMillis();
		for (int k = 0; k < 10000; k++)
		{
			String stra = a(timeNode, str);
		}
		long la2 = System.currentTimeMillis();
		System.out.println(la2 - la1);

		long lb1 = System.currentTimeMillis();
		for (int k = 0; k < 10000; k++)
		{
			String stra = b(timeNode, str);
		}
		long lb2 = System.currentTimeMillis();
		System.out.println(lb2 - lb1);*/

		long c = System.currentTimeMillis();
		for (int k = 0; k < 100; k++)
		{
			String stra = c(timeNode, str);
            System.out.println(stra);
		}
		long c1 = System.currentTimeMillis();
		System.out.println(c1 - c);

	}

	public static String c(int timeNode, String str) {
		int index = str.indexOf(",");
        if (index < 0) {
            if (isClear(str, timeNode)) {
                return "";
            }else{
                return str;
            }
        }
		while (index >= 0) {
            //1,2,3
            String substring = str.substring(0, index);
            if (isClear(substring, timeNode)){
                str = str.substring(index + 1);
            }
            else {
                break;
            }
            index = str.indexOf(",");
		}
		return str;
	}

	public static Boolean isClear(String temp, int timeNode)
	{
		if ("".equals(temp))
		{
			return true;
		}
		long time;
		try
		{
			time = Long.parseLong(temp);
		}
		catch (NumberFormatException e)
		{
			return true;
		}
		return timeNode > time;
	}

	public static String a(int timeNode, String str)
	{
		String[] split = str.split(",");
		StringBuffer stringBuffer = null;
		if (!"".equals(split[0]) && timeNode > Long.parseLong(split[0]))
		{
			int i = 0;
			for (; i < split.length; i++)
			{
				if (!"".equals(split[i]) && timeNode < Long.parseLong(split[i]))
				{
					break;
				}
			}
			if (i <= split.length - 1)
			{
				stringBuffer = new StringBuffer(split[i]);
				for (int j = i + 1; j < split.length; j++)
				{
					stringBuffer.append(",").append(split[j]);
				}
			}
		}
		return stringBuffer == null ? "" : stringBuffer.toString();
	}

	public static String b(int timeNode, String str)
	{
		String[] split = str.split(",");
		StringBuffer stringBuffer = null;
		for (int i = 0; i < split.length; i++)
		{
			if (!"".equals(split[i])
					&& timeNode < Long.parseLong(split[i]))
			{
				if (stringBuffer == null)
				{
					stringBuffer = new StringBuffer(split[i]);
				}
				else
				{
					stringBuffer.append(",").append(split[i]);
				}
			}
		}
		return stringBuffer == null ? "" : stringBuffer.toString();
	}

}
