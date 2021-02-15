import java.util.Stack;

/*
 * @lc app=leetcode.cn id=538 lang=java
 *
 * [538] 把二叉搜索树转换为累加树
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
    public TreeNode convertBST(TreeNode root) {
        if(root == null){
            return root;
        }
        Stack<TreeNode> stack = new Stack<>();
        int val = 0;
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()){
            if(cur != null){
                stack.push(cur);
                cur = cur.right;
            }else{
                TreeNode sumNode = stack.pop();
                sumNode.val += val;
                val = sumNode.val;
                cur = sumNode.left;
            }
        }
        return root;
    }
}


// class Solution{
//     int pre;
//     public TreeNode convertBST(TreeNode root){
//         pre = 0;
//         traversal(root);
//         return root;
//     }

//     private void traversal(TreeNode root){
//         if(root == null){
//             return;
//         }
//         traversal(root.right);
//         pre += root.val;
//         root.val = pre;
//         traversal(root.left);
//     }
// }
// @lc code=end

