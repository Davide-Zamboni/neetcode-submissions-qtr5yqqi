class Solution {
    private Set<Integer> visited = new HashSet<>();
    public int rob(int[] nums) {
        if (nums.length == 1){
            return nums[0];
        }
        if (nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }

        int robExcludingFirst = robHouses(1, nums.length - 1, nums);
        int robExcludingLast = robHouses(0, nums.length - 2, nums);
        
        return Math.max(robExcludingFirst, robExcludingLast);
        
        
    }

    public int robHouses(int start, int end, int[] nums){

        int prev = 0;
        int prevPrev = 0;

        for (int i = start; i <= end; i++){
            int robCurrent = prevPrev + nums[i];
            int skipCurrent = prev;

            int best = Math.max(skipCurrent, robCurrent);

            prevPrev = prev;
            prev = best;
        }

        return prev;
    }
}
