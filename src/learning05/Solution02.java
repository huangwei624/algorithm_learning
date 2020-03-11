package learning05;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * 现有矩阵 matrix 如下：
 *
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 *
 * 给定 target = 20，返回 false。
 *
 */
class Solution02 {
	public boolean findNumberIn2DArray(int[][] matrix, int target) {
		for (int i=0,j=matrix[0].length-1;i<matrix.length&&j>=0;){  // 从右上角开始想做遍历
			if(target < matrix[i][j]){  // 向左
				j--;
			} else if (target> matrix[i][j]) {      // 向下
				i++;
			}else{
				return true;
			}
		}
		return false;
	}
	public static void main(String[] args){
		ArrayList<Integer> integers = new ArrayList<>();
		integers.add(1);
		integers.add(2);
		integers.add(3);
		Integer[] integers1 = integers.toArray(new Integer[0]);
	}
}
