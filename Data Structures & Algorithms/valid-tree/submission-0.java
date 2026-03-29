class Solution {
    public Map<Integer,List<Integer>> adjacencyMap = new HashMap<>();
    public Set<Integer> visitedNodes = new HashSet<>();

    public boolean validTree(int n, int[][] edges) {
       
        for (int i = 0; i < n; i++){
            adjacencyMap.put(i, new ArrayList<>());
        }

        for (int[] edge : edges){
            adjacencyMap.get(edge[1]).add(edge[0]);
            adjacencyMap.get(edge[0]).add(edge[1]);
        }

        if (!dfs(edges, 0, -1)) return false;
        return visitedNodes.size() == n;
    }

    public boolean dfs(int[][] edges, int node, int parent){
        if (visitedNodes.contains(node)) {
            return false;
        }

        visitedNodes.add(node);

        List<Integer> nextNodes = adjacencyMap.get(node);

        for(int nextNode : nextNodes){
            if (nextNode == parent){
                continue;
            }
            if(!dfs(edges,nextNode, node)){
                return false;
            }
        }
        return true;

    }
}
