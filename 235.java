/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/**
    对于递归，要进行分类讨论，然后对每种情况深入递归
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int x = root.val;
        if(p.val>x&&q.val>x)
            return lowestCommonAncestor(root.right,p,q);
        if(p.val<x&&q.val<x)
            return lowestCommonAncestor(root.left,p,q);
        return root;
        
    }
}