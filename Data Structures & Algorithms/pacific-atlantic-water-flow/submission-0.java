class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        Set<List<Integer>> pacificSet = new HashSet<>();
        Set<List<Integer>> atlanticSet = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();
        int rows = heights.length;
        int cols = heights[0].length;


        for(int j = 0; j < cols; j++){
            dfs(heights, 0, j, pacificSet);
        }

        for(int i = 1; i < rows; i++){
            dfs(heights, i, 0, pacificSet);
        }

        for (int i = 0; i < rows; i++){
            dfs(heights, i, cols - 1, atlanticSet);
        }

        for (int j = 0; j < cols - 1; j++){
            dfs(heights, rows - 1, j, atlanticSet);
        }

        pacificSet.stream()
            .filter(atlanticSet::contains)
            .forEach(result::add);

        return result;

        
    }

    public void dfs(int[][] heights, int r, int c, Set<List<Integer>> seaSet){
        if(r < 0 || c < 0 || r > heights.length - 1 || c > heights[0].length - 1){
            return;
        }
        List<Integer> pos = Arrays.asList(r,c);
        if(seaSet.contains(pos)){
            return;
        }
        seaSet.add(pos);

        //up
        if(r - 1 >= 0 && heights[r][c] <= heights[r-1][c]){
            dfs(heights, r-1, c, seaSet);
        }

        //left
        if(c - 1 >= 0 && heights[r][c] <= heights[r][c-1]){
            dfs(heights, r, c - 1, seaSet);
        }

        //down
        if(r + 1 < heights.length && heights[r][c] <= heights[r+1][c]){
            dfs(heights, r+1, c, seaSet);
        }

        //right
        if(c + 1 < heights[0].length && heights[r][c] <= heights[r][c+1]){
            dfs(heights, r, c + 1, seaSet);
        }
    }
}
