class Solution {
    public int orangesRotting(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        Queue<int[]> queue = new ArrayDeque<>();
        int freshCount = 0;
        for (int i = 0; i < r; i++){
            for (int j = 0; j < c; j++){
                if (grid[i][j] == 1){
                    freshCount++;
                }
                if (grid[i][j] == 2){
                    queue.offer(new int[]{i,j});
                }
            }
        }

        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
        int time = 0;
        while (!queue.isEmpty() && freshCount > 0){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                for(int[] direction : directions){
                    int row = cell[0] + direction[0];
                    int column = cell[1] + direction[1];

                    if (row >= 0 && column >= 0 && row < grid.length && column < grid[0].length && grid[row][column] == 1){
             
                        grid[row][column] = 2;
                        queue.offer(new int[]{row, column});
                        freshCount--;
                    }
                }
            }
            time ++;
        }
        if(freshCount == 0){
            return time;
        }
        return -1;
        
    }
}
