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
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 分别用来记录当前A和B节点
        ListNode curA = headA;
        ListNode curB = headB;
        int lenA = 0,lenB =0;

        // 统计A和B的长度
        while(curA !=null){
            lenA++;
            curA = curA.next;
        }
        while(curB!=null){
            lenB++;
            curB=curB.next;
        }
        curA=headA;
        curB=headB;

        // 让curA永远是最长链表的头，lenA是最长的长度，这样方便运算
        if(lenB>lenA){

            // 交换lenA和lenB
            int tmpLen = lenA;
            lenA=lenB;
            lenB=tmpLen;

            // 交换curA和curB
            ListNode tmpNode =curA;
            curA=curB;
            curB=tmpNode;
        }

        int gap = lenA-lenB;
        //让curA和curB末尾位置对齐
        while(gap-->0){
            curA=curA.next;
        }
        // 遍历curA和curB，遇到相同的就直接返回
        while(curA!=null){
            if(curA==curB){
                return curA;
            }
            curA=curA.next;
            curB=curB.next;
        }
        return null;

        
    }
}