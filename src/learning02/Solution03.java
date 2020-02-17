package learning02;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1:
 *
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2]
 * 示例 2:
 *
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [9,4]
 * 说明:
 *
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 */
public class Solution03 {
	public static Integer[] intersection(int[] nums1, int[] nums2) {
		Set<Integer> _nums1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
		Set<Integer> _nums2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());
		
		ArrayList<Integer> res = new ArrayList<>();
		_nums1.forEach(item -> {
			if(_nums2.contains(item)){
				res.add(item);
			}
		});
		
		return res.toArray(new Integer[0]);
	}
	
	public static void main(String[] args){
	    int[] nums1 = {1,2,2,1}, nums2 = {2,2};
	    System.out.println(Arrays.toString(intersection(nums1, nums2)));;
	}
}
