package cn.ws.leetcode.algorithm;

import java.util.HashSet;

/**
 * 无重读字符的最长子串
 *
 * @author shun
 * @date 2020-12-25 14:43
 */
public class Subject_003_lengthOfLongestSubstring {

	public static void main(String[] args) {
		String s = "pwwkew";
		System.out.println(lengthOfLongestSubstring(s));
	}

	public static int lengthOfLongestSubstring(String s) {
		HashSet<Character> set = new HashSet();
		int start = 0;
		int max = 0;
		for (int i = 0; i < s.length(); i++) {
			int length = start - i;
			for (int j = start; j < s.length(); j++) {
				if (set.contains(s.charAt(j))) {
					start = j;
					break;
				}
				else {
					set.add(s.charAt(j));
					length++;
				}
			}
			if (length > max) {
				max = length;
			}
			set.remove(s.charAt(i));
		}

		return max;
	}
}
