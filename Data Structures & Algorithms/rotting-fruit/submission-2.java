class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;

        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < columns; c++) {
                if(grid[r][c] == 2) {
                    queue.offer(new int[] {r, c});
                }
                if(grid[r][c] == 1) {
                    freshCount++;
                }
            }
        }

        int minutes = 0;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (freshCount > 0 && !queue.isEmpty()) {
            minutes++;
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                System.out.println("cell = " + cell[0] + "," + cell[1] + ", minutes = " + minutes);
                for(int[] direction : directions) {
                    int nr = cell[0] + direction[0];
                    int nc = cell[1] + direction[1];

                    if(nr < 0 || nc < 0 || nr > rows - 1 || nc > columns - 1) {
                        continue;
                    }
                    if(grid[nr][nc] != 1) {
                        continue;
                    }
                    grid[nr][nc] = 2;
                    freshCount --;
                    queue.offer(new int[] {nr, nc});
                }
            }
        }

        if(freshCount > 0) {
            return - 1;
        }
        return minutes;
    }
}
