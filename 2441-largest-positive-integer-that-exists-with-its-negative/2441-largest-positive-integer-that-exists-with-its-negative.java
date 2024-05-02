class Solution {
    public int findMaxK(int[] nums) {
        Arrays.sort(nums);
        
        int l = 0;
        int h = nums.length - 1;
        
        while(l<h){
            if(-nums[l]==nums[h]){
                return nums[h];
            }
            else if(-nums[l]>nums[h]){
                ++l;
            }
            else{
                --h;
            }
        }
        return -1;
    }
}