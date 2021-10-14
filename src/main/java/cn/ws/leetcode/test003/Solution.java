package cn.ws.leetcode.test003;


import java.util.LinkedList;
import java.util.List;

/**
 *示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 */
public class Solution {
    public static void main(String[] args) {
        int i = lengthOfLongestSubstring("");
        System.out.println(i);
    }

    public static int lengthOfLongestSubstring(String s) {
        List<String> list = new LinkedList<>();
        List<String> list2 = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            String str = String.valueOf(new char[]{s.charAt(i)});
            if (!list.contains(str)) {
                list.add(str);
            }
            else {
                list2.add(str);
            }
        }
        return 0;
    }
}