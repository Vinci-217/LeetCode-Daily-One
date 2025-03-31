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

// 第二次自己做
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
        dfs(root);
        return root;
    }

    private void dfs(TreeNode node){
        if(node==null) return;
        TreeNode l = node.left;
        TreeNode r = node.right;
        node.left = r;
        node.right = l;
        dfs(node.left);
        dfs(node.right);
    }
}