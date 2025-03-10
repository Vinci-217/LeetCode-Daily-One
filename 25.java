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
    public ListNode reverseKGroup(ListNode head, int k) {

        int n = 0;
        ListNode node = head;
        while(node!=null){
            n++;
            node = node.next;
        }

        ListNode dummy = new ListNode(0,head);
        ListNode p0 = dummy;

        while(n>=k){
            n-=k;
           
            ListNode pre = null;
            ListNode cur = p0.next;
            for(int i=0;i<k;i++){
                ListNode nxt = cur.next;
                cur.next = pre;
                pre = cur;
                cur = nxt;
            }
            ListNode nxt = p0.next;
            p0.next.next = cur;
            p0.next = pre;
            p0 = nxt;
        }
        return dummy.next;

        

    }
}

// 第二次自己撕出来了

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head);
        ListNode p0 = dummy.next;

        int n = 0;
        while (p0 != null) {
            n++;
            p0 = p0.next;
        }

        ListNode cur = dummy;
        while (n - k >= 0) {
            n-=k;
            ListNode curNext = cur.next;
            ListNode pre = cur;
            ListNode node = pre.next;
            for (int i = 0; i < k; i++) {
                ListNode nxt = node.next;
                node.next = pre;
                pre = node;
                node = nxt;
            }
            cur.next = pre;
            curNext.next = node;
            cur = curNext;
        }


        return dummy.next;
    }
}