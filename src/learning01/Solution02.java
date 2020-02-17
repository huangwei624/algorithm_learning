package learning01;

import java.util.Stack;

/**
 * 括号匹配问题：
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 */
public class Solution02 {
	
	public static boolean isValid(String s) {
		if(s.length() % 2 != 0) return false;
		Stack<Character> characters = new Stack<>();
		for(Character c: s.toCharArray()){
			if(c == '('){
				characters.push(')');
			}else if(c == '{'){
				characters.push('}');
			}else if (c == '['){
				characters.push(']');
			}else if(characters.isEmpty() || characters.pop() != c){
				return false;
			}
		}
		return characters.isEmpty();
	}
	public static void main(String[] args){
		System.out.println(Solution02.isValid("()[]{}"));
		System.out.println(Solution02.isValid("([)"));
	}
}
