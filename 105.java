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
    Map<Integer,Integer> map = new HashMap<>();
    int[] preorder,inorder;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        for(int i = 0;i<n;i++){
            map.put(inorder[i],i);
        }
        this.preorder = preorder;
        this.inorder = inorder;
        return dfs(0,n,0,n);
    }

    private TreeNode dfs(int preL,int preR,int inL,int inR){
        if(preL == preR){
            return null;
        }
        int rootval = preorder[preL];
        int rootIndex = map.get(rootval);
        int leftSize = rootIndex - inL;
        TreeNode left = dfs(1+preL,1+preL+leftSize,inL,inL+leftSize);
        TreeNode right = dfs(1+preL+leftSize,preR,1+inL+leftSize,inR);
        return new TreeNode(rootval,left,right);
    }

}