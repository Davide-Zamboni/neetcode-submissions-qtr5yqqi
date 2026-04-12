class Solution {
    public int maxSubArray(int[] nums) {

        int bestEndingHere = nums[0];
        int bestOverall = nums[0];

        for (int i = 1; i < nums.length; i++){
            bestEndingHere = Math.max(nums[i], bestEndingHere + nums[i]);
            bestOverall = Math.max(bestOverall, bestEndingHere);
        }

        return bestOverall;
        
    }
}
