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
    List<String> ans = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null) return ans;
        StringBuilder path = new StringBuilder();
        dfs(root,path);
        return ans;
    }

    private void dfs(TreeNode node,StringBuilder path){

        path.append(node.val);
        if(node.left!=null){
            path.append("->");
            dfs(node.left,new StringBuilder(path.toString()));
            path.delete(path.length()-2,path.length());
        }
        if(node.right!=null){
            path.append("->");
            dfs(node.right,new StringBuilder(path.toString()));
            path.delete(path.length()-2,path.length());
        }
        if(node.left==null&&node.right==null){
            ans.add(path.toString());
//            path.delete(path.length()-3,path.length());
            return;
        }

        return;


    }
}
