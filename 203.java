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
    public ListNode removeElements(ListNode head, int val) {

        // 头结点优化代码，只需要考虑next代码
        ListNode dummy = new ListNode(0,head);
        ListNode node = dummy;
        while (node.next != null) {
            if(node.next.val==val){
                node.next = node.next.next;
            }
            else{
                node = node.next;
            }
        }
        return dummy.next;
    }
}