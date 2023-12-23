class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        for(int i=nums.length-1;i>=0;i--){
            return nums[nums.length-k];
        }
        return 0;
    }
}