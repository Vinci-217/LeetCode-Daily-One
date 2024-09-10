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