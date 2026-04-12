class Solution {
    List<List<Integer>> result = new ArrayList<>();
    Set<Integer> visited = new HashSet<>();
    public List<List<Integer>> permute(int[] nums) {

        backtrack(nums, 0, new ArrayList<>());
        return result;
    }

    public void backtrack (int[] nums, int i, List<Integer> path){
        if(path.size() == nums.length){
            result.add(new ArrayList<>(path));
            return;
        }

        for(int j = 0; j < nums.length; j++){
            if (visited.contains(j)){
                continue;
            }
            visited.add(j);
            path.add(nums[j]);
            backtrack(nums, j, path);
            visited.remove(j);
            path.remove(path.size() - 1);
        }
    }
}
