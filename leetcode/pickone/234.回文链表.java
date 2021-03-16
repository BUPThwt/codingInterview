/*
 * @lc app=leetcode.cn id=234 lang=java
 *
 * [234] 回文链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = null;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            ListNode temp = slow.next;
            slow.next = pre;
            pre = slow;
            slow = temp;
        }
        if(fast != null){
            slow = slow.next;
        }
        while(pre != null && slow != null){
            if(pre.val != slow.val){
                return false;
            }
            pre = pre.next;
            slow = slow.next;
        }
        return true;
    }
}
// @lc code=end

