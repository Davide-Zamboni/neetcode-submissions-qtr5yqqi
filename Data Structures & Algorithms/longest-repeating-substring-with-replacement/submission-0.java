class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character,Integer> repPos = new HashMap<>();
        int left = 0;

        int maxf = 0;
        int res = 0;

        for (int right = 0; right < s.length(); right++){
            char rightC = s.charAt(right);
            repPos.put(rightC, repPos.getOrDefault(rightC, 0) + 1);
            maxf = Math.max(maxf, repPos.get(rightC));
            int window = right - left + 1;
            while(window - maxf > k){
                char leftC = s.charAt(left);
                repPos.put(leftC, repPos.get(leftC) - 1);
                left++;
                window = right - left + 1;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
        
    }
}
