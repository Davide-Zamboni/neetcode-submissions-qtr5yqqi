class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        Arrays.sort(nums);
        int result = 1;
        int tmpMax = 1;
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i]==nums[i+1]){
                continue;
            }
            if(nums[i+1] == nums[i] + 1){
                tmpMax++;
                if(tmpMax > result){
                    result = tmpMax;
                }
            }
            else {
                tmpMax = 1;
            }
        }
        return result;
    }
}

