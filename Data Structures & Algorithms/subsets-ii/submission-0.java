class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(nums, 0, new ArrayList<>());
        return result;
    }

    public void backtrack(int[] nums, int i, List<Integer> path){
        result.add(new ArrayList<>(path));

        for(int j = i; j < nums.length; j++){
            if(j > i && nums[j] == nums[j - 1]){
                continue;
            }

            path.add(nums[j]);
            backtrack(nums, j + 1, path);
            path.remove(path.size() - 1);

        }

    }
}
