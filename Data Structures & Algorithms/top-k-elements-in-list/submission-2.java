class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> frequencyMap = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            frequencyMap.put(nums[i], frequencyMap.getOrDefault(nums[i],0)+1);
        }
        List<Integer> result = new ArrayList();

        for (int i=0; i<k; i++){
            int maxValue=Integer.MIN_VALUE;
            int maxKey=Integer.MIN_VALUE;
            for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
                Integer key = entry.getKey();
                Integer value = entry.getValue();
                if(value>maxValue && !result.contains(key)){
                    maxValue=value;
                    maxKey = key;
                }
            }
            result.add(maxKey);
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
        
        
    }
}
