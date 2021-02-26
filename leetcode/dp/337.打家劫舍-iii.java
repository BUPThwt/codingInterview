import com.apple.laf.AquaButtonRadioUI.RadioButtonBorder;

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
        int[] dp = robRange(root);
        return Math.max(dp[0], dp[1]);
    }

    private int[] robRange(TreeNode root){
        if(root == null){
            return new int[]{0, 0};
        }
        int cur = root.val;
        int[] left = robRange(root.left);
        int[] right = robRange(root.right);
        // 当前节点抢
        int val1 = cur + left[1] + right[1];
        int val2 = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return new int[]{val1, val2};
    }
}
// @lc code=end

