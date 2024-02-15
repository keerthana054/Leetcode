import java.util.Arrays;

public class Solution {
    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        long[] presum = new long[nums.length];
        long sum = 0;

        for (int i = 0; i < nums.length; ++i) {
            presum[i] = sum;
            sum += nums[i];
        }

        for (int i = nums.length - 1; i >= 2; --i) {
            if (nums[i] < presum[i]) {
                return presum[i] + nums[i];
            }
        }

        return -1;
    }
}
