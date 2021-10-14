package cn.ws.leetcode.JianZhi;

/**
 * <p>
 *
 * </p>
 *
 * @author shun
 * @date 2020-06-24 15:48
 */
public class Offer03_replaceSpace
{
	public static void main(String[] args)
	{
		System.out.println(replaceSpace(" "));
	}
	public static String replaceSpace(String s) {
		StringBuffer stringBuffer = new StringBuffer();
		for (int i = 0; i < s.length(); i++)
		{
			char c = s.charAt(i);
			if(c ==' '){
				stringBuffer.append("%20");
			}else{
				stringBuffer.append(c);
			}
		}
		return stringBuffer.toString();
	}
}
