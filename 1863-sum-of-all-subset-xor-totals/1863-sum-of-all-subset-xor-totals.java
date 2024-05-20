class Solution {
    int res = 0;
    public int subsetXORSum(int[] nums) {
        subsets(nums, 0, 0);
        return res;
    }
    
    void subsets(int[] nums, int start, int xor) {
        res += xor;
        
        for(int i = start; i < nums.length; i++) {
            subsets(nums, i+1, xor ^ nums[i]);
        }
    }
}