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
    List<String> list = new LinkedList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        dfs(root, new StringBuilder());
        return list;
    }

    private void dfs(TreeNode node, StringBuilder str) {
        if (node == null)
            return;
        if(str.length()!=0)
            str.append("->").append(node.val);
        else
            str.append(node.val);
        if (node.left == node.right) {
            list.add(str.toString());
            return;
        }
        dfs(node.left,new StringBuilder(str.toString()));
        dfs(node.right,new StringBuilder(str.toString()));
    }
}