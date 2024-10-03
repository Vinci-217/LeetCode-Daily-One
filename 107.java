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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> vals = new ArrayList<>(n);
            while (n-- > 0) {
                TreeNode node = queue.poll();
                vals.add(node.val);
                if(node.left!=null)
                    queue.offer(node.left);
                if(node.right !=null)
                    queue.offer(node.right);
            }
            ans.add(vals);
        }
        Collections.reverse(ans);
        return ans;
    }
}