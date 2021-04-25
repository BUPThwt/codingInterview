import javax.print.attribute.standard.PresentationDirection;

/*
 * @lc app=leetcode.cn id=889 lang=java
 *
 * [889] 根据前序和后序遍历构造二叉树
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
class Solution {
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        if(pre == null || pre.length == 0){
            return null;
        }
        return construct(pre, 0, pre.length, post, 0, post.length);
    }

    public TreeNode construct(int[] pre, int preStart, int preEnd, int[] post, int postStart, int postEnd){
        if(preStart == preEnd){
            return null;
        }
        TreeNode root = new TreeNode(pre[preStart]);
        if(preEnd - preStart == 1){
            return root;
        }
        int left = pre[preStart + 1];
        int index = postStart;
        for(int i = postStart; i < postEnd; i++){
            if(left == post[i]){
                index = i;
                break;
            }
        }
        int length = index - postStart + 1;
        int leftPreStart = preStart + 1;
        int leftPreEnd = leftPreStart + length;
        int leftPostStart = postStart;
        int leftPostEnd = postStart + length;
        int rightPreStart = leftPreEnd;
        int rightPreEnd = preEnd;
        int rightPostStart = index + 1;
        int rightPostEnd = postEnd - 1;
        root.left = construct(pre, leftPreStart, leftPreEnd, post, leftPostStart, leftPostEnd);
        root.right = construct(pre, rightPreStart, rightPreEnd, post, rightPostStart, rightPostEnd);
        return root;
    }
}
// @lc code=end

