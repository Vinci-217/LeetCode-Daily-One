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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode prev = null;
        TreeNode node = root;
        while(!stack.isEmpty()||node!=null){
            while(node!=null){
                stack.push(node);
                node=node.left;
            }
            node=stack.pop();
            if(node.right==null||node.right==prev){
                ans.add(node.val);
                prev=node;
                node=null;
            }
            else{
                stack.push(node);
                node=node.right;
            }
        }
        return ans;
    }
}

