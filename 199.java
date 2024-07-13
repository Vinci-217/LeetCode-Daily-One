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

    private List<Integer> list=new LinkedList<>();

    public List<Integer> rightSideView(TreeNode root) {
        DFS(root,0);
        return list;

    }

    private void DFS(TreeNode node,int depth){
        if(node==null)
            return;
        if(depth==list.size())
            list.add(node.val);
        DFS(node.right,depth+1);
        DFS(node.left,depth+1);
        


    }
}