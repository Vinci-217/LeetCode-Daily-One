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
    private int ans;
    public int goodNodes(TreeNode root) {
        dfs(root,Integer.MIN_VALUE);
        return ans;
    }
    private void dfs(TreeNode node,int max){
        if(node==null){
            return ;
        }
        if(node.val>=max){
            ans++;
            max=Math.max(node.val,max);
        }
        if(node.left==node.right){
            return;
        }
        dfs(node.left,max);
        dfs(node.right,max);
    }
}