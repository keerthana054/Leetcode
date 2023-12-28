class Solution {
    public int maximalSquare(char[][] matrix) {
        int i ,j;
        int max=0,n=matrix.length,m=matrix[0].length;
        int mat[][]= new int [n][m];
       for(i=0;i<n;i++)
       {
           for(j=0;j<m;j++)
           {
             if(i==0 || j==0 || matrix[i][j]=='0')
             {
                 mat[i][j]=Integer.parseInt(String.valueOf(matrix[i][j]));
                 
             }
             else
             {
                 mat[i][j]=Math.min(Math.min(mat[i-1][j-1],mat[i-1][j]),mat[i][j-1])+1;
             }
             
             if(mat[i][j]>max)
             {
                 max=mat[i][j];
             }
           }
       }
    return max*max;
    }
}