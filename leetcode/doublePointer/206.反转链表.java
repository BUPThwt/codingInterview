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
 *     ListNode(int x) { val = x; }
 * }
 */
// class Solution {
//     public ListNode reverseList(ListNode head) {
//         ListNode cur = head;
//         ListNode pre = null;
//         while(cur != null){
//             ListNode temp = cur.next;
//             cur.next = pre;
//             pre = cur;
//             cur = temp;
//         }
//         return pre;
//     }
// }

class Solution{
    public ListNode reverseList(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode result = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return result;
    }
}
// @lc code=end

