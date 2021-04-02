import com.apple.laf.AquaButtonBorder.Dynamic;

/*
 * @lc app=leetcode.cn id=61 lang=java
 *
 * [61] 旋转链表
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
    public ListNode rotateRight(ListNode head, int k) {
        //不需要移动的场景
        if(head == null || k == 0){
            return head;
        }
        int length = 0;
        ListNode cur = head;
        while(cur != null){
            length++;
            cur = cur.next;
        }
        // 算出从那边开始切割
        int index = length - k % length;
        ListNode dummyHead = new ListNode(0);
        ListNode cur1 = head;
        while(--index > 0){
            cur1 = cur1.next;
        }
        //cur1为旋转后的最后一个点
        dummyHead.next = cur1.next;
        cur1.next = null;
        // 将新链表与head相连
        ListNode cur2 = dummyHead;
        while(cur2.next != null){
            cur2 = cur2.next;
        }
        cur2.next = head;
        return dummyHead.next;

    }
}
// @lc code=end

