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
    public int goodNodes(TreeNode root) {
        return visit(root, root.val);
        
    }

    public int visit (TreeNode node, int maxVal){
        if(node == null){
            return 0;
        }

        int toAdd = 0;
        if(node.val >= maxVal){
            toAdd = 1;
        }

        maxVal = Math.max(node.val, maxVal);
        int leftVal = visit(node.left, maxVal);
        int rightVal = visit(node.right, maxVal);
        return toAdd + leftVal + rightVal;
    }
}
