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
    List<Integer> ans = new LinkedList<>();

    public List<Integer> inorderTraversal(TreeNode root) {

        middle(root);
        return ans;

    }

    private void middle(TreeNode node) {
        if(node==null)
            return;
        middle(node.left);
        ans.add(node.val);
        middle(node.right);
    }
}