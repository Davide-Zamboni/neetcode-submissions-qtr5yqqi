class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int max = 0;
         boolean[][] visited = new boolean[r][c];
        for (int i = 0; i < r; i++){
            for (int j = 0; j < c; j++){
                if (grid[i][j] == 1){
                    max = Math.max(max, dfs(grid, i,j, visited));
                }
                
            }
        }

        return max;
        
    }

    public int dfs(int[][] grid, int i, int j, boolean[][] visited){
        if (i < 0 || j < 0 || i > grid.length - 1 || j > grid[0].length - 1 || grid[i][j] == 0){
            return 0;
        }

        if (visited[i][j]){
            return 0;
        }
        visited[i][j] = true;
        int up = dfs(grid, i + 1, j, visited);
        int down = dfs(grid, i - 1, j, visited);
        int left = dfs(grid, i, j + 1, visited);
        int right = dfs(grid, i, j - 1, visited);

        return 1 + up + down + left + right;
    }
}
