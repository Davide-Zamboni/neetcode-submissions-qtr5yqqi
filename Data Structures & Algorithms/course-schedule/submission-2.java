class Solution {
    private Map<Integer, List<Integer>> prereqMap = new HashMap<>();
    private Set<Integer> visited = new HashSet<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        for (int i = 0; i < numCourses; i++) {
            prereqMap.put(i, new ArrayList<>());
        }

        for (int[] p : prerequisites) {
            prereqMap.get(p[0]).add(p[1]);
        }

        for (int c = 0; c < numCourses; c++){
            if(!dfs(c)){
                return false;
            }
        }

        return true;
    }

    public boolean dfs(int course){
        if (visited.contains(course)){
            return false;
        }

        if (prereqMap.get(course).isEmpty()) {
            return true;
        }


        visited.add(course);
        for (int toVisit : prereqMap.get(course)){
            if (!dfs(toVisit)){
                return false;
            }
        }
        visited.remove(course);
        prereqMap.put(course, new ArrayList<>());
        return true;
    }
}
