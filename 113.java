

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

    public List<List<Integer>> ans = new ArrayList<>();
    public int targetSum;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root==null)
            return new ArrayList<>();
        this.targetSum = targetSum;
        List<Integer> path = new ArrayList<>();
        int sum = 0;
        dfs(root,path,sum);
        return ans;
    }
    private void dfs(TreeNode node,List<Integer> path,int sum){

        if(node==null)
            return;
        sum+=node.val;
        path.add(node.val);

        if(sum==targetSum&&node.left==null&&node.right==null){
            ans.add(path);
            return;
        }
//        System.out.println(node.val);
        dfs(node.left,new ArrayList<>(path),sum);
        dfs(node.right,new ArrayList<>(path),sum);

    }
}
//leetcode submit region end(Prohibit modification and deletion)
