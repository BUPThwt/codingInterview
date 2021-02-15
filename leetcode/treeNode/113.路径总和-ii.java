import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import javax.management.relation.Role;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import org.graalvm.compiler.nodes.graphbuilderconf.IntrinsicContext.SideEffectsState;

/*
 * @lc app=leetcode.cn id=113 lang=java
 *
 * [113] 路径总和 II
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
//     public List<List<Integer>> pathSum(TreeNode root, int sum) {
//         List<List<Integer>> result = new ArrayList<>();
//         List<Integer> path = new ArrayList();
//         dfs(root, sum, path, result);
//         return result;
//     }
    
//     private void dfs(TreeNode node, int sum, List<Integer> path, List<List<Integer>> result){
//         if(node == null){
//             return;
//         }
//         List<Integer> subList = new ArrayList<>(path);
//         subList.add(node.val);
//         if(node.left == null && node.right == null && sum == node.val){
//             result.add(subList);
//             return;
//         }
//         if(node.left != null){
//             dfs(node.left, sum - node.val, subList, result);
//         }
//         if(node.right != null){
//             dfs(node.right, sum - node.val, subList, result);
//         }
//         return;
//     }
// }


class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList();
        dfs(root, sum, path, result);
        return result;
    }
    
    private void dfs(TreeNode node, int sum, List<Integer> path, List<List<Integer>> result){
        if(node == null){
            return;
        }
        path.add(node.val);
        if(node.left == null && node.right == null){
            if(sum == node.val){
                result.add(new ArrayList<>(path));
            }
            path.remove(path.size() - 1);
            return;
        }
        if(node.left != null){
            dfs(node.left, sum - node.val, path, result);
        }
        if(node.right != null){
            dfs(node.right, sum - node.val, path, result);
        }
        path.remove(path.size() - 1);
    }
}
// @lc code=end

