class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0, new ArrayList<>());
        return result;
        
    }


    public void backtrack (int[] nums, int i, List<Integer> path){
        if(i >= nums.length){
            result.add(new ArrayList<>(path));
            return;
        }
        path.add(nums[i]);
        backtrack(nums,i+1,path);
        path.remove(path.size() - 1);
        backtrack(nums,i+1,path);
    }
}
