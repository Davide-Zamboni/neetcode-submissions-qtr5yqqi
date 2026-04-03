class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> results = new ArrayList<>();
        
        // Sort to enable early pruning when current number exceeds remaining target
        Arrays.sort(nums);
        
        backtrack(nums, target, 0, new ArrayList<>(), results);
        return results;
    }

    private void backtrack(
        int[] nums,
        int remainingTarget,
        int startIndex,          // prevent going backwards, avoids duplicate combos
        List<Integer> currentCombo,
        List<List<Integer>> results
    ) {
        // Base case: exact match, snapshot current combo and add to results
        if (remainingTarget == 0) {
            results.add(new ArrayList<>(currentCombo));
            return;
        }

        // Try each candidate starting from startIndex
        for (int i = startIndex; i < nums.length; i++) {

            // Pruning: since array is sorted, all further numbers will also exceed target
            if (nums[i] > remainingTarget) break;

            // Choose: add current number to the combination
            currentCombo.add(nums[i]);

            // Recurse: pass i (not i+1) because we can reuse the same element
            backtrack(nums, remainingTarget - nums[i], i, currentCombo, results);

            // Un-choose: remove last element to backtrack and try next candidate
            currentCombo.remove(currentCombo.size() - 1);
        }
    }
}