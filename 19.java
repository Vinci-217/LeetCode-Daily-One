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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0,head);
        ListNode left = dummy;
        ListNode right = dummy;
        for(int i=0;i<n;i++){
            right = right.next;
        }
        while(right.next!=null){
            left=left.next;
            right = right.next;
        }
        left.next = left.next.next;
        return dummy.next;

    }
}

// 第二次做法，两次遍历
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0,head);
        ListNode cur = dummy.next;
        int length = 0;
        while(cur!=null){
            length++;
            cur = cur.next;
        }
        cur = dummy;
        for(int i = 0;i<length-n;i++){
            cur = cur.next;
        }
        if(cur.next==null){
            cur.next = null;
        }
        else{
            cur.next = cur.next.next;
        }

        return dummy.next;
    }
}

// 第三次做法，一次遍历（核心在于先走出差距，类似于链表相交）
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0,head);
        ListNode left = dummy;
        ListNode right = dummy;
        while(n-->0){
            right = right.next;
        }
        while(right.next!=null){
            left = left.next;
            right = right.next;
        }
        left.next = left.next.next;
        return dummy.next;
    }
}