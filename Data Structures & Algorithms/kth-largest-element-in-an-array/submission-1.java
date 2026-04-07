class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums){
            minHeap.offer(num);
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        while(!minHeap.isEmpty()){
            maxHeap.offer(minHeap.poll());
        }

        for (int i = 0; i < k -1; i++){
            maxHeap.poll();
        }

        return maxHeap.poll();
        
    }
}
