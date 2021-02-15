import java.util.LinkedList;
import java.util.Queue;

import org.graalvm.compiler.lir.amd64.AMD64Move.LeaDataOp;

/*
 * @lc app=leetcode.cn id=100 lang=java
 *
 * [100] 相同的树
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
// class Solution {
//     public boolean isSameTree(TreeNode p, TreeNode q) {
//         if(p == null && q == null){
//             return true;
//         }
//         if(p == null || q == null){
//             return false;
//         }
//         if(p.val != q.val){
//             return false;
//         }
//         return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
//     }
// }


class Solution{
    public boolean isSameTree(TreeNode p, TreeNode q){
        if(p == null && q == null){
            return true;
        }
        if(p == null || q == null){
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(p);
        queue.offer(q);
        while(!queue.isEmpty()){
            TreeNode first = queue.poll();
            TreeNode second = queue.poll();
            if(first == null && second == null){
                continue;
            }
            if(first == null || second == null){
                return false;
            }
            if(first.val != second.val){
                return false;
            }
            queue.offer(first.left);
            queue.offer(second.left);
            queue.offer(first.right);
            queue.offer(second.right);
        }
        return true;
    }
}
// @lc code=end

