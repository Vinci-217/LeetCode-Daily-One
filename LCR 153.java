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
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    int target;

    public List<List<Integer>> pathTarget(TreeNode root, int target) {
        this.target = target;
        dfs(root, 0);
        return ans;
    }

    private void dfs(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        sum += root.val;
        path.add(root.val);
        if (sum == target && root.left == null && root.right == null) {
            ans.add(new ArrayList<>(path));
        }
        dfs(root.left, sum);
        dfs(root.right, sum);
        path.remove(path.size() - 1);
    }
}