class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), result, 0);
        return result;
    }

    private void backtrack(int[] candidates, int target, int start, List<Integer> current, List<List<Integer>> result, int sum) {
        if(sum == target) {
        result.add(new ArrayList<>(current));
        return;
    }

    if(sum>target) {
        return;
    }

    for(int i=start; i<candidates.length;i++) {
        current.add(candidates[i]);
        backtrack(candidates, target, i, current, result, sum + candidates[i]);
        current.remove(current.size()-1);
    }
}
}