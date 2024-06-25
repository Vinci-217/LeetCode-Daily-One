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

    private int ans = Integer.MAX_VALUE;

    public int minDepth(TreeNode root) {
        dfs(root,0);
        return root !=null? ans:0;
    }
    // cnt表示路径上的节点个数
    private void dfs(TreeNode node, int cnt){
        if(node==null)
            return;
        cnt++;
        // 如果到了终点了
        if(node.left==node.right){
            ans = Math.min(ans,cnt);
            return;
        }
        dfs(node.left,cnt);
        dfs(node.right,cnt);
    }
}