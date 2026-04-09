class Solution {
    private List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Arrays.sort(nums);
        backTrack(nums, target, new ArrayList<Integer>(), 0, 0);
        return result;
    }

    public void backTrack(int[] nums, int target, List<Integer> cur, int i, int total){
        if(total == target){
            result.add(new ArrayList<>(cur));
            return;
        }

        for (int j = i; j < nums.length; j++){
            if(nums[j] + total > target){
                return;
            }

            cur.add(nums[j]);
            backTrack(nums, target, cur, j, total + nums[j]);
            cur.remove(cur.size() - 1);
        }
    }
}