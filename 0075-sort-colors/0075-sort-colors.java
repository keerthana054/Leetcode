class Solution {
    public void sortColors(int[] nums) {
        int j=-1;
        for(int i=0; i < nums.length; i++){
            if(nums[i] == 0){
                int tmp = nums[j+1];
                nums[j+1] = nums[i];
                nums[i] = tmp;
                ++j;
            }
        }
        for(int i=j+1; i < nums.length; i++){
            if(nums[i] == 1){
                int tmp = nums[j+1];
                nums[j+1] = nums[i];
                nums[i] = tmp;
                ++j;
            }
        }
    }
}