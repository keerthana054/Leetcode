class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sumOfNumsLength = 0;
        for (int i = 0; i<n; i++) {
            sumOfNumsLength += nums[i];
        }
        int sumOfN = n * (n + 1) / 2;

        return sumOfN - sumOfNumsLength;
    }
}