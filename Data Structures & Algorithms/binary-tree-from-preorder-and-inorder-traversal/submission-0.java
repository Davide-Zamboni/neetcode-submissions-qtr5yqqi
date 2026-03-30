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

    public Map<Integer, Integer> pos = new HashMap<>();
    int pre_indx = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        for ( int i = 0; i < inorder.length; i++){
            pos.put(inorder[i], i);
        }

        return dfs(preorder, 0, inorder.length - 1);

    }

    public TreeNode dfs(int[] preorder, int left, int right){
        if (left > right){
            return null;
        }
        int root_val = preorder[pre_indx];
        pre_indx++;

        TreeNode node = new TreeNode(root_val);
        int mid = pos.get(root_val);
        node.left = dfs(preorder, left, mid -1);
        node.right = dfs(preorder, mid + 1, right);
        return node;
    }
}
