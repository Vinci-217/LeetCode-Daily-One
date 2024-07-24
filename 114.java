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

    List<TreeNode> list = new ArrayList<TreeNode>();

    public void flatten(TreeNode root) {
        dfs(root);
        for (int i = 1; i < list.size(); i++) {
            TreeNode pre = list.get(i - 1);
            TreeNode cur = list.get(i);
            pre.left = null;
            pre.right = cur;
        }
        return;
    }

    private void dfs(TreeNode node) {
        if (node == null)
            return;
        list.add(node);
        dfs(node.left);
        dfs(node.right);

    }
}