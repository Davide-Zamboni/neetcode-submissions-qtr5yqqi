class Solution {
    HashMap<String, PriorityQueue<String>> connections = new HashMap<>();
    List<String> result = new ArrayList<>();
    public List<String> findItinerary(List<List<String>> tickets) {

        for(List<String> pair : tickets){
            if(connections.containsKey(pair.get(0))){
                connections.get(pair.get(0)).add(pair.get(1));
            }
            else {
                PriorityQueue<String> queue = new PriorityQueue<>();
                queue.add(pair.get(1));
                connections.put(pair.get(0), queue);
            }
        }

        dfs("JFK");
        Collections.reverse(result);
        return result;
    }

    public void dfs(String node){
        PriorityQueue<String> pq = connections.get(node);
        while(pq != null && !pq.isEmpty()){
            String next = pq.poll();
            dfs(next);
        }
        result.add(node);
    }
}
