class Solution {
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int longestIncreasingPath(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int ans = 0;

        int[][] dp = new int[rows][cols];

        for (int i = 0; i < rows; i++){
            Arrays.fill(dp[i], -1);
        }

        for(int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                ans = Math.max(ans, dfs(matrix, i, j, dp));
            }
        }
        return ans;
    }

    private int dfs(int[][] matrix, int r, int c, int[][] dp) {
        if (dp[r][c] != -1) {
            return dp[r][c];
        }
        int best = 1;
        for (int[] dir : directions) {
            int nr = r + dir[0];
            int nc = c + dir[1];

            if (nr >= 0 && nc >= 0 && nr < matrix.length && nc < matrix[0].length
                && matrix[r][c] < matrix[nr][nc]) {
    
                best = Math.max(best, 1 + dfs(matrix, nr, nc, dp));
            }
        }
        dp[r][c] = best;

        return best;
    }
}
