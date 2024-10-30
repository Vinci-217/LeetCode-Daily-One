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
    public boolean isPalindrome(ListNode head) {
        ListNode curr = head;
        Stack<ListNode> stack = new Stack<>();

        if(head==null||head.next==null){
            return true;
        }

        while(curr!=null){
            stack.push(curr);
            curr=curr.next;
        }
        curr = head;
        // 本质上是翻转以后比较
        while(curr!=null){
            if(curr.val!=stack.peek().val){
                return false;
            }
            curr=curr.next;
            stack.pop();
        }
        return true;
        

    }
}

// 字符串更加简洁的方法
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
    public boolean isPalindrome(ListNode head) {
        StringBuilder sb = new StringBuilder();
        while(head!=null){
            sb.append(head.val);
            head = head.next;
        }
        String s1 = sb.toString();
        String s2 = sb.reverse().toString();
        return s1.equals(s2);
    }
}


// 第二次做的方法
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
    public boolean isPalindrome(ListNode head) {
        StringBuilder sb = new StringBuilder();
        ListNode cur = head;
        while(cur!=null){
            sb.append(cur.val);
            cur = cur.next;
        }
        String str = sb.toString();
        if(str.equals(sb.reverse().toString()))
            return true;
        return false;
    }
}