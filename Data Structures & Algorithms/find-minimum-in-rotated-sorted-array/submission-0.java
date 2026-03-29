class Solution {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int res = nums[start];

        while(start <= end){
            if(nums[start] <= nums[end]){
                res = Math.min(res, nums[start]);
                break;
            }
            int mid = start + ( end - start) / 2;
            if(nums[mid] > nums[end]){
                res = nums[end];
                start = mid + 1;
            }
            else {
                res = Math.min(res, nums[mid]);
                end = mid - 1;
            }
        }

        return res;
        
    }
}
