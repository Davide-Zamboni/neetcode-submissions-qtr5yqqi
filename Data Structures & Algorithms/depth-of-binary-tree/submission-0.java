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
    public int maxDepth(TreeNode root) {
        return visit(root, 0);
    }

    public int visit(TreeNode node, int depth){
        if(node == null){
            return depth;
        }
        depth++;
        return Math.max(visit(node.right, depth), visit(node.left, depth));


    }


}
