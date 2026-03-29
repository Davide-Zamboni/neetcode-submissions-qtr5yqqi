class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer,List<Integer>> adjagencyTable = new HashMap<>();
        for(int i = 0; i< numCourses; i++){
            adjagencyTable.put(i, new ArrayList());
        }

        for(int[] prereq : prerequisites){
            adjagencyTable.get(prereq[0]).add(prereq[1]);
        }

        Set<Integer> visiting = new HashSet<>();
        for(int i = 0; i< numCourses; i++){
            if(!dfs(visiting, adjagencyTable, i)){
                return false;
            }
        }
        return true;
    }

    public boolean dfs(Set<Integer> visiting,  Map<Integer,List<Integer>> adjagencyTable, int course){
        if (visiting.contains(course)){
            return false;
        }
        visiting.add(course);
        List<Integer> preRequisites = adjagencyTable.get(course);

        for(int preReq : preRequisites){
            if(!dfs(visiting, adjagencyTable, preReq)){
                return false;
            }
        }
        visiting.remove(course);
        return true;
    }
}
