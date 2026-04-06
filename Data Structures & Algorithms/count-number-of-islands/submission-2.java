class Solution {
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int colums = grid[0].length;

        int result = 0;

        for (int i = 0; i < rows; i++){
            for (int j = 0; j < colums; j++){
                if (grid[i][j] == '1'){
                    dfs(grid, i, j);
                    result++;
                }
            }
        }

        return result;
        
    }

    public void dfs(char[][] grid, int i, int j){
        if (i < 0 || j < 0 || i > grid.length -1 || j > grid[0].length -1){
            return;
        }

        if (grid[i][j] == '0'){
            return;
        }

        grid[i][j] = '0';

        dfs(grid, i+1, j);
        dfs(grid, i-1, j);
        dfs(grid, i, j+1);
        dfs(grid, i, j-1);

    }
}
