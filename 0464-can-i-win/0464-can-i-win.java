class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        return util1(maxChoosableInteger,desiredTotal);
    }

    public boolean util1(int maxChoosableInteger, int desiredTotal) {
        if (maxChoosableInteger * (maxChoosableInteger + 1) / 2 < desiredTotal) {
            return false;
        }
        Boolean dp[] = new Boolean[1 << (maxChoosableInteger + 1)];
        return helper(maxChoosableInteger, desiredTotal, dp, 0, 0);
    }

    public boolean helper(int maxChoosableInteger, int desiredTotal, Boolean dp[], int mask, int sum) {
        if (dp[mask] != null) {
            return dp[mask];
        }
        dp[mask] = false;
        for (int i = 1; i <= maxChoosableInteger; i++) {
            if ((mask & (1 << i)) == 0) {
                if (sum + i >= desiredTotal) {
                    dp[mask] = true;
                } else {
                    boolean hisAns = helper(maxChoosableInteger, desiredTotal, dp, (mask | (1 << i)), sum + i);
                    if (hisAns == false) {
                        dp[mask] = true;
                    }
                }
            }
            if (dp[mask]) {
                break;
            }
        }
        return dp[mask];
    }
}