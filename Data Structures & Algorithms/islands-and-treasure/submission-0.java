class Solution {

    public void islandsAndTreasure(int[][] grid) {
        int rows = grid.length;
        int colums = grid[0].length;

        Queue<int[]> bfsQueue = new LinkedList<>();

        for (int i = 0; i < rows; i++){
            for (int j = 0; j < colums; j++){
                if (grid[i][j] == 0){
                    bfsQueue.offer(new int[]{i,j});
                }
            }
        }

        int[] rowDirs = {1,-1,0,0};
        int[] colDirs = {0,0,1,-1};

        while(!bfsQueue.isEmpty()){
            int[] curr = bfsQueue.poll();
            int currRow = curr[0];
            int currCol = curr[1];

            for(int dir = 0; dir < 4; dir++){
                int nextRow = currRow + rowDirs[dir];
                int nextColumn = currCol + colDirs[dir];

                if(nextRow < 0 || nextColumn < 0 || nextRow >= rows || nextColumn >= colums){
                    continue;
                }

                if(grid[nextRow][nextColumn] != Integer.MAX_VALUE){
                    continue;
                }

                grid[nextRow][nextColumn] = grid[currRow][currCol] + 1;
                bfsQueue.offer(new int[]{nextRow, nextColumn});
            }
        }
    
        
        
    }


}
