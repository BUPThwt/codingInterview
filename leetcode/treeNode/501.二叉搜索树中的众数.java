import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import java.util.Stack;

import org.graalvm.compiler.nodes.java.ArrayLengthNode;

/*
 * @lc app=leetcode.cn id=501 lang=java
 *
 * [501] 二叉搜索树中的众数
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
//     List<Integer> ans = new ArrayList<>();
//     int maxCount = 0;
//     int count = 0;
//     public int[] findMode(TreeNode root) {
//         dfs(root);
//         int index = 0;
//         int[] result = new int[ans.size()];
//         for(int i : ans){
//             result[index++] = i;
//         }
//         return result;
//     }

//     private void dfs(TreeNode root){
//         if(root == null){
//             return;
//         }
//         dfs(root.left);
//         if(pre == null){
//             count = 1;
//         }else if(pre.val == root.val){
//             count++;
//         }else{
//             count = 1;
//         }
//         pre = root;
//         if(count == maxCount){
//             ans.add(root.val);
//         }else if(count > maxCount){
//             ans.clear();
//             ans.add(root.val);
//             maxCount = count;
//         }
//         dfs(root.right);
//     }

// }

class Solution{
    public int[] findMode(TreeNode root){
        int count = 0;
        int maxCount = 0;
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()){
            if(cur != null){
                stack.push(cur);
                cur = cur.left;
            }else{
                cur = stack.pop();
                if(pre == null){
                    count = 1;
                }else if(pre.val == cur.val){
                    count++;
                }else{
                    count = 1;
                }
                pre = cur;
                if(count == maxCount){
                    ans.add(cur.val);
                }else if(count > maxCount){
                    ans.clear();
                    maxCount = count;
                    ans.add(cur.val);
                }
                cur = cur.right;
            }
        }
        int index = 0;
        int[] result = new int[ans.size()];
        for(int i : ans){
            result[index++] = i;
        }
        return result;
        
    }
}
// @lc code=end

