package learning02;

import java.util.*;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 */
public class Solution02 {
	public static boolean isAnagram(String s, String t) {
		if(s.length() != t.length()) return false;
		char[] t_char = t.toCharArray();
		ArrayList<Character> list = new ArrayList<>();
		for(Character c: t_char){
			list.add(c);
		}
		char[] s_char = s.toCharArray();
		for(Character c:s_char){
			if (list.contains(c)){
				list.remove(c);
			}else{
				return false;
			}
		}
		return true;
	}
	
	// 推荐方法二
	public static boolean isAnagram2(String s, String t) {
		if(s.length() != t.length())
			return false;
		int[] alpha = new int[26];  // 初始化26个字母标识为都为 0
		for(int i = 0; i< s.length(); i++) {
			alpha[s.charAt(i) - 'a'] ++;        // s 负责在对应位加1
			alpha[t.charAt(i) - 'a'] --;        // t 负责在对应位减一
		}
		for(int i=0;i<26;i++)   // 如果26个字母标识为都还为0，说明是字母异位词
			if(alpha[i] != 0)
				return false;
		return true;
	}
	
	public static void main(String[] args){
	    String s = "anagram", t = "nagarnm";
		boolean res = isAnagram2(s, t);
		System.out.println(res);
	}
}
