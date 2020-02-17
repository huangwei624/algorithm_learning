package learning02;

import java.util.Arrays;

/**
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 *
 * 示例 1：
 *
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 * 示例 2：
 *
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 *  
 *
 * 限制：
 *
 * 0 <= k <= arr.length <= 1000
 * 0 <= arr[i] <= 1000
 */
public class Solution01 {
	// 简单方式
	public static int[] getLeastNumbers(int[] arr, int k) {
		if (k < arr.length) throw new IllegalArgumentException("参数不合法");
		Arrays.sort(arr);
		return Arrays.copyOfRange(arr, 0, k);
	}
	
	// 使用堆， 针对大数据量的排序
	// todo
	
	public static void main(String[] args){
		int[] arr = new int[]{2, 50, 3, 20, 23, 7, 12, 34, 56};
		System.out.println(Arrays.toString(getLeastNumbers(arr, 4)));;
	}
}
