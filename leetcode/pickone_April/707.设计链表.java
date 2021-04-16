import com.apple.laf.AquaButtonBorder.Dynamic;

/*
 * @lc app=leetcode.cn id=707 lang=java
 *
 * [707] 设计链表
 */

// @lc code=start
class MyLinkedList {


    ListNode dummyHead;
    int size = 0;

    /** Initialize your data structure here. */
    public MyLinkedList() {
        dummyHead = new ListNode(0);
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index >= size || index < 0){
            return -1;
        }
        ListNode cur = dummyHead;
        while(index >= 0){
            cur = cur.next;
            index--;
        }
        return cur.val;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        ListNode node = new ListNode(val);
        ListNode cur = dummyHead.next;
        dummyHead.next = node;
        node.next = cur;
        size++;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index > size){
            return;
        }
        if(index < 0){
            addAtHead(val);
            return;
        }
        ListNode node = new ListNode(val);
        ListNode cur = dummyHead;
        while(index > 0){
            cur = cur.next;
            index--;
        }
        ListNode temp = cur.next;
        cur.next = node;
        node.next = temp;
        size++;
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index < 0 || index >= size){
            return;
        }
        ListNode cur = dummyHead;
        while(index > 0){
            cur = cur.next;
            index--;
        }
        ListNode temp = cur.next.next;
        cur.next = temp;
        size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
// @lc code=end

