class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length, sum=Integer.MAX_VALUE, val, i, j;
        for(i=0;i<n;i++){
            for(j=0;j<n;j++){
                val=0;
                if(i>0){ 
                    val=matrix[i-1][j];
                    if(j>0) val = Math.min(val,matrix[i-1][j-1]);
                    if(j<n-1) val = Math.min(val,matrix[i-1][j+1]);
                }
                matrix[i][j]+=val;
                if(i == n-1) sum = Math.min(sum, matrix[i][j]);
            }
        }
        return sum;
    }
}