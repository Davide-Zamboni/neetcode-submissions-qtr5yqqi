class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int keptCount = 1;
        int lastEnd = intervals[0][1];
        
        for (int i = 0; i < intervals.length; i++) {
            int currentStart = intervals[i][0];
            int currentEnd = intervals[i][1];

            if (currentStart >= lastEnd){
                keptCount++;
                lastEnd = currentEnd;
            }
        }

        return intervals.length - keptCount;

        
    }


}
