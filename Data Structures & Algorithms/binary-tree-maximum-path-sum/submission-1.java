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
    public int result;
    public int maxPathSum(TreeNode root) {
        result = root.val;
        sumTree(root);
        return result;
    }


    public int sumTree(TreeNode root){
        if( root == null ){
            return 0;
        }

        int leftSum = Math.max(sumTree(root.left), 0);
        int rightSum = Math.max(sumTree(root.right), 0);

        result = Math.max(result, root.val + leftSum + rightSum);
        return root.val + Math.max(leftSum, rightSum);
        
    }
}
