/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        if(root==null)
            return ans;
        TreeNode node  = root;
        while(!stack.isEmpty()||node!=null){
            while(node!=null){
                stack.push(node);
                node=node.left;
            }
            node = stack.pop();
            ans.add(node.val);
            node=node.right;
        }
        return ans;

    }

}

// 一个更好的解决方法对节点的颜色进行标记，如果已经访问过就是2，否则为1
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    class Node{
        TreeNode node;
        int color;
        public Node(TreeNode node,int color){
            this.node = node;
            this.color = color;
        }
    }


    List<Integer> ans = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Deque<Node> stack = new LinkedList<>();
        if(root==null)
            return ans;
        stack.push(new Node(root,1));
        while(!stack.isEmpty()){
            Node cur = stack.pop();
            if(cur.node ==null){
                continue;
            }
            if(cur.color ==1){
                stack.push(new Node(cur.node.right,1));
                stack.push(new Node(cur.node,2));
                stack.push(new Node(cur.node.left,1));
            }
            else{
                ans.add(cur.node.val);
            }
        }
        return ans;
    }
}