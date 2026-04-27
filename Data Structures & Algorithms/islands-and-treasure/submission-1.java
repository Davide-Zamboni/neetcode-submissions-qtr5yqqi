class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int rows = grid.length;
        int colums = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < rows; i++){
            for (int j = 0; j < colums; j++){
                if (grid[i][j] == 0){
                    queue.offer(new int[]{i,j});
                }
            }
        }
        
        int[][] dirs = {{-1,0}, {1,0}, {0,1}, {0,-1}};

        while (!queue.isEmpty()){
            int[] curr = queue.poll();
            int currRow = curr[0];
            int currCol = curr[1];

            for(int[] dir : dirs){
                int nextRow = currRow + dir[0];
                int nextCol = currCol + dir[1];

                if (nextRow < 0 || nextCol < 0 || nextRow > rows -1 || nextCol > colums - 1){
                    continue;
                }

                if(grid[nextRow][nextCol] != Integer.MAX_VALUE) {
                    continue;
                }

                grid[nextRow][nextCol] = 1 + grid[currRow][currCol];
                queue.offer(new int[]{nextRow, nextCol});
            }
        }
        
    }
}
