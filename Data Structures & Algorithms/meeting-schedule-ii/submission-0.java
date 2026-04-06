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
        List<Integer> startTimes = new ArrayList<>();
        List<Integer> endTimes = new ArrayList<>();

        for (Interval interval : intervals){
            startTimes.add(interval.start);
            endTimes.add(interval.end);
        }

        Collections.sort(startTimes);
        Collections.sort(endTimes);

        int startIndex = 0;
        int endIndex = 0;
        int count = 0;
        int overlaps = 0;

        while (startIndex < intervals.size()){
        if(startTimes.get(startIndex) < endTimes.get(endIndex)) {
            count++;
            overlaps = Math.max(overlaps, count);
            startIndex++;
        } else {
            count --;
            endIndex++;
        }
        }

        return overlaps;
    }
}
