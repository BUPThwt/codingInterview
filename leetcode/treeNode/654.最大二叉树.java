/*
 * @lc app=leetcode.cn id=654 lang=java
 *
 * [654] 最大二叉树
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums.length == 0){
            return null;
        }
        return dfs(nums, 0, nums.length);
    }

    private TreeNode dfs(int[] nums, int begin, int end){
        if(begin == end){
            return null;
        }
        int rootVal = 0;
        int midIndex = begin;
        for(int i = begin; i < end; i++){
            if(nums[i] > rootVal){
                rootVal = nums[i];
                midIndex = i;
            }
        }
        TreeNode root = new TreeNode(rootVal);
        root.left = dfs(nums, begin, midIndex);
        root.right = dfs(nums, midIndex + 1, end);
        return root;
    }
}
// @lc code=end

