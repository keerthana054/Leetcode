class Solution {
    public int countPartitions(int[] nums) {
        int sum = 0;
        int res = 0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            sum+=nums[i];
        }

        if(sum%2==0){
            res = n-1;
        }
        return res;
    }
}