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
    List<Integer> result = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        visit(root,0);
        return result;
    }

    public void visit (TreeNode node, int height){
        if(node == null){
            return;
        }

        if(result.size() == height){
            result.add(node.val);
        }
        
        height++;
        visit(node.right, height);
        visit(node.left, height);
    }
}
