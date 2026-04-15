class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        boolean[][] visited = new boolean[n][n];

        minHeap.offer(new int[]{grid[0][0], 0, 0});
        visited[0][0] = true;

        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while(!minHeap.isEmpty()){
            int cur[] = minHeap.poll();
            int time = cur[0];
            int r = cur[1];
            int c = cur[2];

            if(r == n-1 && c == n-1){
                return time;
            }

            for (int[] dir : dirs){
                int nr = r + dir[0];
                int nc = c + dir[1];
                if (nr < 0 || nr >= n || nc < 0 || nc >= n || visited[nr][nc]) continue;
                visited[nr][nc] = true;
                int nextTime = Math.max(time, grid[nr][nc]);

                minHeap.offer(new int[]{nextTime, nr, nc});
            }
        }

        return -1;
        
    }
}
