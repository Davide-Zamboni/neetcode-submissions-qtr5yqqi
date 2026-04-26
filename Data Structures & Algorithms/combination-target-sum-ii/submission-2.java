class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);
        backtrack(candidates, target, 0, new ArrayList<>(), 0);

        return result;
        
    }

    public void backtrack (int[] candidates, int target, int i, List<Integer> tmpResult, int tmpSum){
        if(tmpSum == target){
            result.add(new ArrayList<>(tmpResult));
            return;
        }

        for (int j = i; j < candidates.length; j++){
            if(j > i && candidates[j] == candidates[j - 1]){
                continue;
            }

            if (tmpSum + candidates[j] > target){
                break;
            }

            tmpResult.add(candidates[j]);
            backtrack(candidates, target, j + 1, tmpResult, tmpSum + candidates[j]);
            tmpResult.remove(tmpResult.size() - 1);
        }
    }
}
