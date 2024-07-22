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
    private int ans=0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null)
            return 0;
        dfs(root);
        return ans;
    }

    // 获取当前节点的最大深度
    private int dfs(TreeNode node){
        if(node==null)
            return 0;
        int left = dfs(node.left);
        int right = dfs(node.right);
        ans=Math.max(ans,left+right);
        return Math.max(left,right)+1;
    }
}