class Solution {
    public long wonderfulSubstrings(String word) {
        long[] cnt = new long[1024]; 
        cnt[0] = 1;
        int mask = 0; 
        long ans = 0;
        char[] chars = word.toCharArray();
        for (char c : chars) {
            int idx = c - 'a';
            mask ^= 1 << idx; 
            ans += cnt[mask]; 
            for (int i = 0; i < 10; i++) {
                int lookFor = mask ^ (1 << i);
                ans += cnt[lookFor];
            }
            cnt[mask]++; 
        }
        return ans;
    }
}