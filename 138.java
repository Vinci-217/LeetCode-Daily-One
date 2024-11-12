/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {

        if(head==null){
            return head;
        }

        // 第一次遍历，存入map
        Map<Node,Node> map = new HashMap<>();
        Node cur = head;
        while(cur!=null){
            Node node = new Node(cur.val);
            map.put(cur,node);
            cur = cur.next;
        }

        // 第二次遍历，给value的两个指针赋值
        cur = head;
        while(cur!=null){
            Node node = map.get(cur);
            if(cur.next!=null){
                node.next = map.get(cur.next);
            }
            if(cur.random!=null){
                node.random = map.get(cur.random);
            }
            cur = cur.next;
        }
        return map.get(head);

    }
}