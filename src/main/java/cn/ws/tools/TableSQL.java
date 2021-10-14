package cn.ws.tools;

/**
 * <p>
 *
 * </p>
 *
 * @author shun
 * @date 2020-07-16 21:04
 */
public class TableSQL
{
	public static void main(String[] args)
	{
		StringBuffer stringBuffer = new StringBuffer();
		for (int i = 1; i < 1000; i++)
		{
			stringBuffer.append("create table if not exists user_mark_info_" +String.format("%03d", i))
					.append(" like user_mark_info_000;\n");
		}
		System.out.println(stringBuffer.toString());



	}
}
