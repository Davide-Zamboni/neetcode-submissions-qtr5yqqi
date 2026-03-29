/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        Map<Node,Node> oldToNew = new HashMap<>();
        if(node == null){
            return null;
        }
        Node newNode = new Node();
        newNode.val = node.val;
        oldToNew.put(node, newNode);
        dfs(node, newNode, oldToNew);
        return newNode;
    }

    public void dfs(Node node, Node newNode, Map<Node,Node> oldToNew){
        for(Node neighbor : node.neighbors){
            if(oldToNew.containsKey(neighbor)){
                newNode.neighbors.add(oldToNew.get(neighbor));
            }
            else {
                Node nodeCopy = new Node();
                nodeCopy.val = neighbor.val;
                oldToNew.put(neighbor, nodeCopy);
                newNode.neighbors.add(nodeCopy);
                dfs(neighbor, nodeCopy, oldToNew);
            }
        }
    }
}