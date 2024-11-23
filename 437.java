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
    private Map<Long,Integer> cnt = new HashMap<>();
    private int target ;
    private int ans;
    public int pathSum(TreeNode root, int targetSum) {
        cnt.put(0L,1);
        target = targetSum;
        dfs(root,0);
        return ans;
    }
    private void dfs(TreeNode node,long sum){
        if(node ==null){
            return;
        }
        sum+=node.val;
        ans+=cnt.getOrDefault(sum-target,0);
        Integer num = cnt.getOrDefault(sum,0);
        num++;
        cnt.put(sum,num);
        dfs(node.left,sum);
        dfs(node.right,sum);
        num--;
        cnt.put(sum,num);
        
    }
}