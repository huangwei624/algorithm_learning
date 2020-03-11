package learning05;

import java.util.Arrays;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 */
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	
	TreeNode(int x) {
		val = x;
	}
}

public class Solution03 {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		int n = preorder.length;
		if(n==0) return null;
		// 构建父节点
		int rootVal = preorder[0], rootInorder=0;
		for (int i = 0; i < inorder.length; i++) {
			if(rootVal == inorder[i]){
				rootInorder=i;
				break;
			}
		}
		TreeNode root = new TreeNode(rootVal);
		 // 前序遍历 preorder = [3,9,20,15,7]
         // 中序遍历 inorder = [9,3,15,20,7]
		// 递归构建左子树
		root.left = buildTree(Arrays.copyOfRange(preorder, 1, 1+rootInorder),
				Arrays.copyOfRange(inorder, 0, rootInorder));
		// 递归构建右子树
		root.right = buildTree(Arrays.copyOfRange(preorder, 1+rootInorder, n),
				Arrays.copyOfRange(inorder, rootInorder+1, n));
		return root;
	}
}
