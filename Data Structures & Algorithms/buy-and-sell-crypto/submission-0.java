class Solution {
    public int maxProfit(int[] prices) {
        // if (prices.length() < 2) {
        //     return 0;
        // }
        int i = 0;
        int j = 1;

        int result = 0;

        while (j < prices.length){
            if (prices[i] < prices [j]){
                result = Math.max(result, prices[j] - prices[i]);
                j++;
            }
            else {
                if (i < j - 1){
                    i++;
                }
                else {
                    i++;
                    j++;
                }
            }
        }

        return result;
        
    }
}
