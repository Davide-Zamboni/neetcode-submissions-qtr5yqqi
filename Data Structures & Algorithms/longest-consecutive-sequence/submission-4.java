class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();

        for (int num : nums){
            numSet.add(num);
        }

        int count = 0;
        int max = 0;       
        for (int num : nums){
            if(!(numSet.contains(num - 1))){
                count = 1;
                while(numSet.contains(num + 1)){
                    count++;
                    num = num + 1;
                }
                max = Math.max(count, max);
            }
        }

        return max;
        
    }
}
