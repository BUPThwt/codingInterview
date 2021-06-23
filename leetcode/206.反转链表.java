/*
 * @lc app=leetcode.cn id=206 lang=java
 *
 * [206] 反转链表
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
class Solution {
    // public ListNode reverseList(ListNode head) {
    //     if(head == null || head.next == null){
    //         return head;
    //     }
    //     ListNode result = reverseList(head.next);
    //     head.next.next = head;
    //     head.next = null;
    //     return result;
    // }

    public ListNode reverseList(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode cur = head;
        ListNode pre = null;
        while(cur.next != null){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        cur.next = pre;
        return cur;
    }
}
// @lc code=end

