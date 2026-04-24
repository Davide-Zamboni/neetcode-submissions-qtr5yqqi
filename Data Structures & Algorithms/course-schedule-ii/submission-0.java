class Solution {
    Map<Integer, List<Integer>> courseMap = new HashMap<>();
    Set<Integer> visited = new HashSet<>();
     Set<Integer> visiting = new HashSet<>();
    List<Integer> output = new ArrayList<>();
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        for (int i = 0; i < numCourses; i++){
            courseMap.put(i, new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites){
            courseMap.get(prerequisite[0]).add(prerequisite[1]);
        }

        for (int i = 0; i < numCourses; i++){
            if(!dfs(i)){
                return new int[0];
            }
        }

        return output.stream()
            .mapToInt(Integer::intValue).toArray();
    }

    public boolean dfs(int i){
        if(visiting.contains(i)){
            return false;
        }

        if(visited.contains(i)){
            return true;
        }

        visiting.add(i);
        List<Integer> prerequisites = courseMap.get(i);
        for (int prereq : prerequisites) {
            if(!dfs(prereq)){
                return false;
            }
        }
        visiting.remove(i);
        visited.add(i);
        output.add(i);
        return true;
    }
}
