class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[] origin = {0, 0};
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingDouble((int[] p) -> calculateDistance(p, origin)).reversed());

        for(int[] point : points){
            queue.offer(point);
            if (queue.size() > k) {
                queue.poll();
            }
        }

        int [][] result = new int[k][2];
        int i = 0;
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            result[i][0] = point[0];
            result[i][1] = point[1];
            i++;
        }
        return result;
    }

    public static double calculateDistance(int[] p1, int[] p2) {
    return Math.hypot(p1[0] - p2[0], p1[1] - p2[1]);
    }
}
