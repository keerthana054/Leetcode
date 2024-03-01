class Solution {
    public boolean isMatch(String s, String p) {
        int row = p.length() + 1;
        int col = s.length() + 1;
        boolean dp[][] = new boolean[row][col];

        dp[0][0] = true;
        for (int i = 0; i < row; i++) {  // first column
            if (i >= 2 && p.charAt(i - 1) == '*') {
                dp[i][0] = dp[i - 2][0];
            }
        }

        for (int i = 1; i < row; i++) {
            char ptrChar = p.charAt(i - 1);
            for (int j = 1; j < col; j++) {
                char strChar = s.charAt(j - 1);
                if (strChar == ptrChar) { // pattern char equals to string char
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (ptrChar == '.') { // pattern char equals to "."
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (ptrChar == '*') { // pattern char equals to "*"
                    char prevPtrChar = p.charAt(i - 2);
                    if (prevPtrChar == strChar || prevPtrChar == '.') {
                        dp[i][j] = dp[i - 2][j ] ||  dp[i][j - 1]; // check  (row-2)OR (col-1)
                    } else {
                        dp[i][j] = dp[i - 2][j];     // row -2
                    }
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[row - 1][col - 1];
    }
}
