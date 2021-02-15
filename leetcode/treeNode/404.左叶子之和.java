import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=404 lang=java
 *
 * [404] 左叶子之和
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
//     public int sumOfLeftLeaves(TreeNode root) {
//         int sum = 0;
//         if(root == null){
//             return sum;
//         }
//         Queue<TreeNode> queue = new LinkedList<>();
//         queue.offer(root);
//         while(!queue.isEmpty()){
//             TreeNode node = queue.poll();
//             TreeNode left = node.left;
//             TreeNode right = node.right;
//             if(left != null){
//                 queue.offer(left);
//                 if(left.left == null && left.right == null){
//                     sum += left.val;
//                 }
//             }
//             if(right != null){
//                 queue.offer(right);
//             }
//         }
//         return sum;
//     }
// }

class Solution{
    public int sumOfLeftLeaves(TreeNode root){
        if(root == null){
            return 0;    
        }
        int midValue = 0;
        if(root.left != null && root.left.left == null && root.left.right == null){
            midValue = root.left.val;
        }
        return midValue + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);

    }

}
// @lc code=end

