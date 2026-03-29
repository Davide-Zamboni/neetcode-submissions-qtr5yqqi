class Solution {
    public HashMap<Integer, List<Integer>> adjTable = new HashMap<>();
    public Set<Integer> visited = new HashSet<>();
    public int countComponents(int n, int[][] edges) { 
        
        for (int i = 0; i < n; i++){
            adjTable.put(i, new ArrayList());
        }

        for (int[] edge : edges){
            adjTable.get(edge[0]).add(edge[1]);
            adjTable.get(edge[1]).add(edge[0]);
        }

        int count = 0;
        for (int i = 0; i < n; i++){
            if(!visited.contains(i)){
                dfs(i);
                count++;
            }
            
        }

        return count;

    }

    public void dfs(int node){
        if(visited.contains(node)){
            return;
        }

        visited.add(node);
        List<Integer> neighbours = adjTable.get(node);
        for (int neighbour : neighbours){
            dfs(neighbour);
        }
    } 
}
