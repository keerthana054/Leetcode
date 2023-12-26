class Solution {
  public int numTilings(int n) {
        int MOD = 1_000_000_007;
        if (n == 1) return 1;
        
        long[] dp = new long[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] + 2 * prefixSum(dp, i - 3)) % MOD;
        }
        
        return (int) dp[n];
    }
    
    private long prefixSum(long[] dp, int end) {
        long sum = 0;
        int MOD = 1_000_000_007;
        
        while (end >= 0) {
            sum = (sum + dp[end]) % MOD;
            end--;
        }
        
        return sum;
    }

}