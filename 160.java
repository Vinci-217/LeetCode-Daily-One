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

// 双指针
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
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA;
        ListNode pB = headB;
        while(pA!=pB){
            pA = pA==null?headB:pA.next;
            pB = pB==null?headA:pB.next;
        }
        return pA;
    }
}



// 核心在于，要么AB相等，要么AB同时为null，所以在于A!=N
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode A = headA;
        ListNode B = headB;


        while(A!=B){
            A = A==null?headB:A.next;
            B = B==null?headA:B.next;
        }
        return A;

    }
}