/*
 * @lc app=leetcode.cn id=108 lang=java
 *
 * [108] 将有序数组转换为二叉搜索树
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
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0){
            return null;
        }
        return buildTree(nums, 0, nums.length);
    }

    private TreeNode buildTree(int [] nums, int low, int high){
        if(low >= high){
            return null;
        }
        int index = low + (high - low)/2;
        TreeNode root = new TreeNode(nums[index]);
        root.left = buildTree(nums, low, index);
        root.right = buildTree(nums, index + 1, high);
        return root;
    }
}
// @lc code=end

