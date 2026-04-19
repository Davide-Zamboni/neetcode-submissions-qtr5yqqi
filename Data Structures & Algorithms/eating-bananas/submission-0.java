class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = Arrays.stream(piles).max().getAsInt();
        int res = right;

        while (left <= right){
            int mid = left + (right - left) / 2;

            if(canFinishWithinHours(piles, h, mid)){
                res = mid;
                right = mid - 1;
            } else {
            left = mid + 1;
            }
        }
        
        return res;
    }

    public boolean canFinishWithinHours(int[] piles, int h, int speed){
        long hoursNeeded = 0;

        for(int pile : piles){
            hoursNeeded += (pile + speed - 1) / speed;

            if (hoursNeeded > h) {
                return false;
            }
        }

        return hoursNeeded <= h;
    }
}
