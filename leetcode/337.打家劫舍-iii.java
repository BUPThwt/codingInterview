import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=337 lang=java
 *
 * [337] 打家劫舍 III
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int rob(TreeNode root) {
        int[] result = robRange(root);
        return Math.max(result[0], result[1]);
    }

    // 0 不偷，1 偷
    private int[] robRange(TreeNode node){
        if(node == null){
            return new int[]{0, 0};
        }
        int[] left = robRange(node.left);
        int[] right = robRange(node.right);
        int val1 = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        int val2 = left[0] + right[0] + node.val;
        return new int[]{val1, val2};
    }
}
// @lc code=end

