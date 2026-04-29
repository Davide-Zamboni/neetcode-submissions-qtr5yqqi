class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int colums = grid[0].length;

        int max = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < colums; j++) {
                if (grid[i][j] == 1) {
                    max = Math.max(max, dfs(grid, i, j));
                }   
                
            }
        }

        return max;
    }

    int [][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    public int dfs(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i > grid.length - 1 || j > grid[0].length - 1 || grid[i][j] == 0) {
            return 0;
        }

        grid[i][j] = 0;
        int area = 1;
        for (int[] dir : dirs){
            area = area + dfs(grid, i + dir[0], j + dir[1]);
        }

        return area;
    }
}
