import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=257 lang=java
 *
 * [257] 二叉树的所有路径
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
//     public List<String> binaryTreePaths(TreeNode root) {
//         List<String> result = new ArrayList<>();
//         if(root == null){
//             return result;
//         }
//         if(root.left == null && root.right == null){
//             result.add(String.valueOf(root.val));
//         }
//         dfs(root.left, String.valueOf(root.val), result);
//         dfs(root.right, String.valueOf(root.val), result);
//         return result;
//     }

//     private void dfs(TreeNode node, String path, List<String> result){
//         if(node == null){
//             return;
//         }
//         StringBuilder sb = new StringBuilder(path);
//         sb.append("->").append(node.val);
//         if(node.left == null && node.right == null){
//             result.add(sb.toString());
//         }
//         dfs(node.left, sb.toString(), result);
//         dfs(node.right, sb.toString(), result);
//     }
// }



class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        dfs(root, "", result);
        return result;
    }

    private void dfs(TreeNode node, String path, List<String> result){
        if(node == null){
            return;
        }
        StringBuilder sb = new StringBuilder(path);
        sb.append(node.val);
        if(node.left == null && node.right == null){
            result.add(sb.toString());
        }
        sb.append("->");
        dfs(node.left, sb.toString(), result);
        dfs(node.right, sb.toString(), result);
    }
}
// @lc code=end

