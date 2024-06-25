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
    // 函数作用是求当前根的最大深度
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int l_depth = maxDepth(root.left);
        int r_depth = maxDepth(root.right);
        return Math.max(l_depth,r_depth)+1;

    }
}