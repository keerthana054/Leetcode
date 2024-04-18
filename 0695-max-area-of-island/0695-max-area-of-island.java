class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxA = 0;
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    maxA = Math.max(maxA, dfs(grid,i,j));
                }
            }
        }
        return maxA;
    }
    
    public int dfs(int[][] grid, int i, int j){
        if(i<0 || i>=grid.length || j<0 || j>=grid[i].length || grid[i][j]==0){
            return 0;
        }
        
        grid[i][j]=0;
        int count = 1;
        
        count = count + dfs(grid, i, j+1);
        count = count + dfs(grid, i, j-1);
        count = count + dfs(grid, i+1, j);
        count = count + dfs(grid, i-1, j);
        
        return count;
    }
}