package learning04;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

/**
 * 给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。
 *
 * 示例 1:
 *
 * 输入: [10,2]
 * 输出: 210
 *
 * 示例 2:
 *
 * 输入: [3,30,34,5,9]
 * 输出: 9534330
 *
 */
public class Solution01 {
	
	// 第一种
	private class LargerNumberComparator implements Comparator<String> {
		@Override
		public int compare(String a, String b) {
			String order1 = a + b;
			String order2 = b + a;
			return order2.compareTo(order1);
		}
	}
	
	public String largestNumber(int[] nums) {
		// Get input integers as strings.
		String[] asStrs = new String[nums.length];
		for (int i = 0; i < nums.length; i++) {
			asStrs[i] = String.valueOf(nums[i]);
		}
		
		// Sort strings according to custom comparator.
		Arrays.sort(asStrs, new LargerNumberComparator());
		
		// If, after being sorted, the largest number is `0`, the entire number
		// is zero.
		if (asStrs[0].equals("0")) {
			return "0";
		}
		
		// Build largest number from sorted array.
		String largestNumberStr = new String();
		for (String numAsStr : asStrs) {
			largestNumberStr += numAsStr;
		}
		
		return largestNumberStr;
	}
	
	// 优化代码书写
	public static String largestNumber2(int[] nums) {
		StringBuilder sb = new StringBuilder();
		Arrays.stream(nums)
				.mapToObj(String::valueOf)
				.sorted((x, y) -> (y+x).compareTo(x+y))     // 自定义比较器
				.collect(Collectors.toList())
				.forEach(sb::append);
		
		return sb.charAt(0) == '0'? "0": sb.toString();
	}
	
	public static void main(String[] args){
		int[] arr = {3,30,34,5,9};
		System.out.println(largestNumber2(arr));;
	}
}
