class Solution {
    public int maxArea(int[] heights) {
        int start = 0;
        int end = heights.length - 1;

        int max = 0;

        while (start < end){
            int height = Math.min(heights[start], heights[end]);
            int length = end - start;
            max = Math.max(max, height * length);
            if(heights[start] > heights[end]){
                end --;
            }
            else {
                start ++;
            }
        }

        return max;
        
    }
}
