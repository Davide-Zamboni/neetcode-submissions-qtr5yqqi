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
    public boolean canAttendMeetings(List<Interval> intervals) {
        Set<Integer> busyTimes = new HashSet<>();
        for(Interval interval : intervals){
            for(int i = interval.start; i < interval.end; i++){
                if (!busyTimes.add(i)) {
                    return false;
                }
            }
        }
        return true;

    }
}
