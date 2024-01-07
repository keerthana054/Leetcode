class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int totalCount = 0;

        // dp[i][d] represents the number of arithmetic subsequences ending at index i with common difference d
        HashMap<Long, Integer>[] dp = new HashMap[n];

        for (int i = 0; i < n; i++) {
            dp[i] = new HashMap<>();
        }

        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                long diff = (long) nums[i] - nums[j];

                // Check for possible integer overflow
                if (diff < Integer.MIN_VALUE || diff > Integer.MAX_VALUE)
                    continue;

                int count = dp[j].containsKey(diff) ? dp[j].get(diff) : 0;

                // Add the count to the total and update dp[i][diff]
                totalCount += count;
                dp[i].put(diff, dp[i].getOrDefault(diff, 0) + count + 1);
            }
        }

        return totalCount;
    }
}