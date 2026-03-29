class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap <Integer,Integer> numsMap = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            numsMap.put(nums[i],i);
        }

        for(int i=0; i<nums.length; i++){
            if(numsMap.containsKey(target-nums[i]) && numsMap.get(target-nums[i])!= i){
                int secondValue = numsMap.get(target-nums[i]);
                return new int[]{i,secondValue};
            }
        }
        return null;
    }

}
