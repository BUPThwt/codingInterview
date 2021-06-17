import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=109 lang=java
 *
 * [109] 有序链表转换二叉搜索树
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        return buildTree(head, null);
    }

    private TreeNode buildTree(ListNode left, ListNode right){
        if(left == right){
            return null;
        }
        ListNode mid = getMid(left, right);
        TreeNode node = new TreeNode(mid.val);
        node.left = buildTree(left, mid);
        node.right = buildTree(mid.next, right);
        return node;
    }

    public ListNode getMid(ListNode left, ListNode right){
        ListNode slow = left;
        ListNode fast = left;
        while(fast != right && fast.next != right){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
// @lc code=end

