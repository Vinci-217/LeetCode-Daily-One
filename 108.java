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
    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums,0,nums.length-1);
    }

    private TreeNode dfs(int[] nums,int left,int right){
        if(left>right)
            return null;
        // 以升序数组的中间元素作为根节点root
        int mid = left+(right-left)/2;
        TreeNode root = new TreeNode(nums[mid]);
        // 递归构造root的左子树和右子树
        root.left = dfs(nums,left,mid-1);
        root.right = dfs(nums,mid+1,right);
        return root;
    } 
}


// 第二次做法

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
    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums,0,nums.length-1);
    }

    private TreeNode dfs(int[] nums,int left,int right){
        if(left > right){
            return null;
        }
        int m = left + (right-left)/2;
        return new TreeNode(nums[m],dfs(nums,left,m-1),dfs(nums,m+1,right));
    }
}