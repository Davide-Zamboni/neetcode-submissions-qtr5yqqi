class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack (candidates, target, new ArrayList<>(), 0, 0);
        return result;
    }

    public void backtrack(int[] candidates, int target, List<Integer> path, int i, int total){
        if(total == target){
            result.add(new ArrayList<>(path));
            return;
        }

        for(int j = i; j < candidates.length; j++){
            if(j > i && candidates[j] == candidates [j - 1]){
                continue;
            }

            if(candidates[j] + total > target){
                return;
            }

            path.add(candidates[j]);
            backtrack(candidates, target, path, j + 1, total + candidates[j]);
            path.remove(path.size() - 1);
        }

    }
}
