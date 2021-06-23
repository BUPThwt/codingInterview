import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=173 lang=java
 *
 * [173] 二叉搜索树迭代器
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
class BSTIterator {
    int index;
    List<Integer> list;

    public BSTIterator(TreeNode root) {
        list = new ArrayList();
        index = 0;
        dfs(root);
    }
    
    private void dfs(TreeNode node){
        if(node == null){
            return;
        }
        dfs(node.left);
        list.add(node.val);
        dfs(node.right);
    }
    
    public int next() {
        int result = list.get(index);
        index++;
        return result;
    }
    
    public boolean hasNext() {
        return index < list.size();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
// @lc code=end

