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
    int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return res;
    }

    private void dfs(TreeNode root){
        if (root == null) {
            return;
        }

        int leftMax = getMax(root.left);
        int rightMax = getMax(root.right);
        res = Math.max(res, leftMax + rightMax + root.val);

        dfs(root.left);
        dfs(root.right);
    }


     private int getMax(TreeNode root){
        if (root == null) {
            return 0;
        }

        int leftMax = getMax(root.left);
        int rightMax = getMax(root.right);
        int path = root.val + Math.max(leftMax,rightMax);
        return Math.max(0, path);
    }
}
