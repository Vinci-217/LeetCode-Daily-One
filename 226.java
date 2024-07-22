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
    public TreeNode invertTree(TreeNode root) {
        if(root==null)
            return null;
        reverseTreeNode(root);
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
    private void reverseTreeNode(TreeNode node){
        TreeNode leftNode = node.left;
        node.left=node.right;
        node.right=leftNode;
    }

}