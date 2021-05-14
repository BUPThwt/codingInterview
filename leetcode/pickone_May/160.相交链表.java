/*
 * @lc app=leetcode.cn id=160 lang=java
 *
 * [160] 相交链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    // public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    //     ListNode curA = headA;
    //     ListNode curB = headB;
    //     int lenA = 0;
    //     int lenB = 0;
    //     while(curA != null){
    //         lenA++;
    //         curA = curA.next;
    //     }
    //     while(curB != null){
    //         lenB++;
    //         curB = curB.next;
    //     }
    //     curA = headA;
    //     curB = headB;
    //     if(lenB > lenA){
    //         int temp = lenA;
    //         lenA = lenB;
    //         lenB = temp;
    //         ListNode tempNode = curA;
    //         curA = curB;
    //         curB = tempNode;
    //     }
    //     int gap = lenA - lenB;
    //     while(gap-- > 0){
    //         curA = curA.next;
    //     }
    //     while(curA != null){
    //         if(curA == curB){
    //             return curA;
    //         }
    //         curA = curA.next;
    //         curB = curB.next;
    //     }
    //     return null;
    // }

    // 每一条遍历都走过了A+B，消除了长度差
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        ListNode curA = headA;
        ListNode curB = headB;
        while(curA != curB){
            curA = curA == null ? headB : curA.next;
            curB = curB == null ? headA : curB.next;
        }
        return curA;
    }


}
// @lc code=end

