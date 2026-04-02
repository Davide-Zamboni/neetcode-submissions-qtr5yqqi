class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> duplicateMap = new HashMap<>();
        int left = 0;
        int res = 0;

        for (int right = 0; right < s.length(); right++){
            if (duplicateMap.containsKey(s.charAt(right))){
                left = Math.max(duplicateMap.get(s.charAt(right)) + 1, left);
            }
            duplicateMap.put(s.charAt(right), right);
            res = Math.max(res, right - left + 1);
        }
        return res;
    

    }
}
