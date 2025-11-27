class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        int n = nums.length;
        
        long INF = (long)4e18;
        long[] minPref = new long[k];
        for (int i = 0; i < k; i++) {
            minPref[i] = INF;
        }
        
        long prefix = 0;
        long ans = -INF;
        
        minPref[0] = 0;
        
        for (int i = 0; i < n; i++) {
            prefix += nums[i];
            int rem = (i + 1) % k;
            
            if (minPref[rem] != INF) {
                ans = Math.max(ans, prefix - minPref[rem]);
            }
            
            if (prefix < minPref[rem]) {
                minPref[rem] = prefix;
            }
        }
        
        return ans;
    }
}