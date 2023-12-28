class Solution {

    static int helper2(int arr[][]){
        int m = arr.length;
        int n = arr[0].length;

        int dp[][] = new int[m+1][n+1];
        for(var a : dp) Arrays.fill(a,0);
        dp[m-1][n-1] = 1;
    
        for(int i=m-1; i>=0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j == n - 1) continue;
                if (arr[i][j] == 1) dp[i][j] = 0;
                else dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
            }
        }
        return dp[0][0];
    }
    public int uniquePathsWithObstacles(int[][] arr) {

       if(arr[arr.length-1][arr[0].length-1]==1) return 0;
       return helper2(arr);
    }
}