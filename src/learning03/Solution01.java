package learning03;

import javax.xml.stream.events.Characters;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 *示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 */
public class Solution01 {
	// 暴力法.穷举所有的字串，选出不含重复字符的字串，则长度最大的那个就是最后的结果
	public static int lengthOfLongestSubstring(String s) {
		int res=0;
		for (int i = 0; i < s.length(); i++) {
			for (int j = i; j < s.length(); j++) {
				if(allUnique(s, i, j)) res = Math.max(res, j-i+1);
			}
		}
		return res;
	}
	
	// 使用滑动窗口
	public static int lengthOfLongestSubstring2(String s) {
		int res=1, i=0, j=1;    // i , j 分别代表窗口的左边界和右边界(右边界不达)
		HashSet<Character> set = new HashSet<>();
		set.add(s.charAt(0));
		while(j<s.length()){
			if(!set.contains(s.charAt(j))){
				set.add(s.charAt(j++));
				res = Math.max(res, j-i);
			}else{
				set.remove(s.charAt(i++));  // 窗口的左边界向右移动，直到窗口中 重复元素的下一个
			}
		}
		return res;
	}
	
	// 优化滑动窗口
	public static int lengthOfLongestSubstring3(String s) {
		if("".equals(s) || s==null) return 0;
		int res=1, i=0, j=1;    // i , j 分别代表窗口的左边界和右边界(右边界不达)
		HashMap<Character, Integer> map = new HashMap<>();
		map.put(s.charAt(0), 0);
		while(j<s.length()){
			if(map.containsKey(s.charAt(j))){
				i = Math.max(map.get(s.charAt(j))+1, i);
			}
			map.put(s.charAt(j), j);
			res = Math.max(res, j-i+1);
			j++;
		}
		return res;
	}
	
	private static boolean allUnique(String s, int start, int end){
		String subStr = s.substring(start, end+1);
		HashSet<Character> cs = new HashSet<>();
		for(Character c:subStr.toCharArray()){
			if(cs.contains(c)) return false;
			cs.add(c);
		}
		return true;
	}
	
	public static void main(String[] args){
	    String[] s = {"abba", "abcabcbb", "pwwkew", "bbbbb"};
	    for(int i=0; i<s.length;i++){
		    System.out.println(lengthOfLongestSubstring3(s[i]));
	    }
	}
}
