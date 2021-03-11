import java.util.ArrayDeque;
import java.util.Deque;

import org.graalvm.compiler.core.gen.NodeLIRBuilder;

/*
 * @lc app=leetcode.cn id=1457 lang=java
 *
 * [1457] 二叉树中的伪回文路径
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
    int result;
    public int pseudoPalindromicPaths (TreeNode root) {
        result = 0;
        if(root == null){
            return result;
        }
        backTracing(new int[10], root);
        return result;
    }

    private void backTracing(int[] nums, TreeNode node){
        // 此处注意，因为叶子节点在之前没有加过，所以要先加叶子节点的值
        nums[node.val]++;
        if(node.left == null && node.right == null){
            if(isPalindrome(nums)){
                result++;
            }
            nums[node.val]--;
            return;
        }
        if(node.left != null){
            backTracing(nums, node.left);   
        }
        if(node.right != null){
            backTracing(nums, node.right);
        }
        nums[node.val]--;
    }

    private boolean isPalindrome(int[] nums){
        int odd = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] % 2 == 1){
                odd++;
                if(odd > 1){
                    return false;
                }
            }
        }
        return true;
    }

    // public int pseudoPalindromicPaths (TreeNode root) {
    //     if(root == null){
    //         return 0;
    //     }
    //     dfs(root, 0);
    //     return result;
    // }

    // private void dfs(TreeNode node, int num){
    //     num ^= (1 << node.val);
    //     if(node.left == null && node.right == null){
    //         if(num == 0 || (num & (num - 1)) == 0){
    //             result++;
    //         }
    //         return;
    //     }
    //     if(node.left != null){
    //         dfs(node.left, num);
    //     }
    //     if(node.right != null){
    //         dfs(node.right, num);
    //     }
    // }


}
// @lc code=end

