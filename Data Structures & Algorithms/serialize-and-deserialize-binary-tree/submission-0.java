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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder encodedTree = new StringBuilder();
        buldPreorderString(root, encodedTree);
        return encodedTree.toString();
    }

    public void buldPreorderString(TreeNode root, StringBuilder encodedTree){
        if (root == null){
            encodedTree.append("N");
            encodedTree.append(",");
            return;
        }

        encodedTree.append(root.val);
        encodedTree.append(",");

        buldPreorderString(root.left, encodedTree);
        buldPreorderString(root.right, encodedTree);

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> values = new LinkedList<>(Arrays.asList(data.split(",")));
        return buildTree(values);
    }

    public TreeNode buildTree(Queue<String> values){
        String currentValue = values.poll();

        if (currentValue.equals("N")){
            return null;
        }

        TreeNode newNode = new TreeNode(Integer.parseInt(currentValue));
        newNode.left = buildTree(values);
        newNode.right = buildTree(values);

        return newNode;
    }
}
