class Solution {
   public List<List<Integer>> subsets(int[] nums) {
    Arrays.sort(nums); 
    List<List<Integer>> result = new ArrayList<>();
    result.add(new ArrayList<>()); 
    for (int i = 0; i < nums.length; ++i) {
        for (int j = 0, size = result.size(); j < size; ++j) { 
            List<Integer> subset = new ArrayList<>(result.get(j)); 
            subset.add(nums[i]); 
            result.add(subset);
        }
    }
    return result;
}
}