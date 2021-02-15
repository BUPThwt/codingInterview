import java.util.Stack;

/*
 * @lc app=leetcode.cn id=530 lang=java
 *
 * [530] 二叉搜索树的最小绝对差
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
// class Solution {
//     TreeNode pre = null;
//     int result;
//     public int getMinimumDifference(TreeNode root) {
//          result = Integer.MAX_VALUE;
//          dfs(root);
//          return result;
//     }

//     private void dfs(TreeNode root){
//         if(root == null){
//             return;
//         }
//         dfs(root.left);
//         if(pre != null){
//             result = Math.min(result, Math.abs(root.val - pre.val));
//         }
//         pre = root;
//         dfs(root.right);
//     }
// }

class Solution{
    public int getMinimumDifference(TreeNode root){
        Stack<TreeNode> stack = new Stack();
        int result = Integer.MAX_VALUE;
        TreeNode pre = null;
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()){
            if(cur != null){
                stack.push(cur);
                cur = cur.left;
            }else{
                cur = stack.pop();
                if(pre != null){
                    result = Math.min(result, Math.abs(cur.val - pre.val));
                }
                pre = cur;
                cur = cur.right;
            }
        }
        return result;
    }
}


// @lc code=end

