class Solution {
    public Set<Integer> visited = new HashSet<>();
    public Map<Integer, List<Integer>> map = new HashMap<>();
    public boolean validTree(int n, int[][] edges) {

        for(int i = 0; i < n; i++){
            map.put(i, new ArrayList<>());
        }

        for (int[] edge : edges){
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

        if(!dfs(0, -1)){
            return false;
        }

        if(visited.size() < n){
            return false;
        }
        return true;

    }

    public boolean dfs (int node, int parent){
        if(visited.contains(node)){
            return false;
        }

        visited.add(node);
        List<Integer> adjList = map.get(node);

        for (int num : adjList){
            if(num == parent){
                continue;
            }
            if (!dfs(num, node)){
                return false;
            }
        }

        return true;
    }
}
