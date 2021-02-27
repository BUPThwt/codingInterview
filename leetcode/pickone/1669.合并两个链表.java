import javax.management.DynamicMBean;

import com.apple.laf.AquaButtonBorder.Dynamic;

/*
 * @lc app=leetcode.cn id=1669 lang=java
 *
 * [1669] 合并两个链表
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
    // public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
    //     ListNode dummyHead = new ListNode(0);
    //     dummyHead.next = list1;
    //     ListNode cur = dummyHead;
    //     for(int i = 0; i < a; i++){
    //         cur = cur.next;
    //     }
    //     ListNode cur2 = cur.next;
    //     int c = b - a + 1;
    //     for(int i = 0; i < c; i++){
    //         cur2 = cur2.next;
    //     }
    //     cur.next = list2;
    //     while(cur.next != null){
    //         cur = cur.next;
    //     }
    //     cur.next = cur2;
    //     return dummyHead.next;
    // }

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = list1;
        ListNode cur = dummyHead;
        for(int i = 0; i < a; i++){
            cur = cur.next;
        }
        ListNode cur2 = dummyHead;
        for(int i = 0; i <= b + 1; i++){
            cur2 = cur2.next;
        }
        cur.next = list2;
        while(cur.next != null){
            cur = cur.next;
        }
        cur.next = cur2;
        return dummyHead.next;
    }
}
// @lc code=end

