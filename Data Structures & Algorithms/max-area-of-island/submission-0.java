class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int colums = grid[0].length;
        int maxArea = 0;
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < colums; j++){
                maxArea = Math.max(dfs(grid, i, j), maxArea);
            }
        }
        return maxArea;
    }

    public int dfs(int[][] grid, int i, int j){
        if(i < 0 || j < 0 || i > grid.length - 1 || j > grid[0].length - 1
            || grid[i][j] == 0){
                return 0;
        }
        grid[i][j] = 0;
        int res = 1;

        res += dfs(grid, i+1, j);
        res += dfs(grid, i, j+1);
        res += dfs(grid, i-1, j);
        res += dfs(grid, i, j-1);

        return res;
    }
}
