/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        intervals.sort((a, b) -> a.start - b.start);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int maxRooms = 0;

        for (Interval interval : intervals){
            if(minHeap.isEmpty()){
                minHeap.offer(interval.end);
            }
            else if(!minHeap.isEmpty() && interval.start < minHeap.peek()){
                minHeap.offer(interval.end);
            }
            else if(!minHeap.isEmpty() && interval.start >= minHeap.peek()){
                minHeap.poll();
                minHeap.offer(interval.end);
            }
            maxRooms = Math.max(maxRooms, minHeap.size());
        }

        return maxRooms;
    }
}
