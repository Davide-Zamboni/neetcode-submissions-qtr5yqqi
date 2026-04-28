class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {

    
        backtrack(nums, 0, new ArrayList<>(), new boolean[nums.length]);
    

        return result;
        
        
    }

    public void backtrack(int[] nums, int i, List<Integer> path, boolean[] used){
        if(path.size() == nums.length){
            result.add(new ArrayList<>(path));
            return;
        }

        for(int j = 0; j<nums.length; j++){
            if(used[j]){
                continue;
            }
            used[j] = true;
            path.add(nums[j]);
            backtrack(nums, j, path, used);
            path.remove(path.size() - 1);
            used[j] = false;
        }
    }

}
