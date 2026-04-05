class Solution {
    public String longestPalindrome(String s) {
        int start = 0;
        int resLength = 0;

        int n = s.length();

        boolean[][] dp = new boolean[n][n];

        for (int i = n - 1; i >= 0; i--){
            for (int j = i; j < n; j++){
                if(s.charAt(i) == s.charAt(j) &&
                    (j - i <= 2 || dp[i + 1][j-1])){
                        dp[i][j] = true;
                        int subStringLen = j - i + 1;
                        if (resLength < subStringLen){
                            start = i;
                            resLength = subStringLen;
                        }

                    }
            }

        }
        return s.substring(start, start + resLength);
    }
}
