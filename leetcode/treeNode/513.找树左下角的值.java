import java.util.LinkedList;
import java.util.Queue;

import org.graalvm.compiler.lir.amd64.AMD64Move.LeaDataOp;

/*
 * @lc app=leetcode.cn id=513 lang=java
 *
 * [513] 找树左下角的值
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
//     public int findBottomLeftValue(TreeNode root) {
//         Queue<TreeNode> queue = new LinkedList<>();
//         queue.offer(root);
//         int result = root.val;
//         while(!queue.isEmpty()){
//             int size = queue.size();
//             for(int i = 0; i < size; i ++){
//                 TreeNode node = queue.poll();
//                 if(i == 0){
//                     result = node.val;
//                 }
//                 if(node.left != null){
//                     queue.offer(node.left);
//                 }
//                 if(node.right != null){
//                     queue.offer(node.right);
//                 }
//             }
//         }
//         return result;
//     }
// }


class Solution{
    int maxDepth = 0;
    int result = 0;
    public int findBottomLeftValue(TreeNode root){
        result = root.val;
        dfs(root, 0);
        return result;
    }

    private void dfs(TreeNode node, int depth){
        if(node == null){
            return;
        }
        depth++;
        if(depth > maxDepth){
            maxDepth = depth;
            result = node.val;
        }
        dfs(node.left, depth);
        dfs(node.right, depth);
    }
}
// @lc code=end

