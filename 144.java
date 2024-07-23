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
    public List<Integer> preorderTraversal(TreeNode root) {
        
        List<Integer> ans = new ArrayList<>();
        if(root==null)
            return ans;
        
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;

        while(!stack.isEmpty()||node!=null){
            while(node!=null){
                ans.add(node.val);
                stack.push(node);
                node=node.left;
            }
            node = stack.pop();
            node = node.right;
        }
        return ans;

    }
}
