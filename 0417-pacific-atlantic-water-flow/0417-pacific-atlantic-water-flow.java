class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        
        boolean[][] pac = new boolean[rows][cols];
        boolean[][] atl = new boolean[rows][cols];
        
        for(int i=0;i<rows;i++){
            dfs(i,0,rows,cols,pac,heights[i][0],heights);
            dfs(i,cols-1, rows, cols, atl, heights[i][cols-1],heights);
        }
        
        for(int j=0;j<cols;j++){
            dfs(0,j,rows,cols,pac,heights[0][j], heights);
            dfs(rows-1,j,rows,cols,atl, heights[rows-1][j], heights);
        }
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(pac[i][j] && atl[i][j]){
                    result.add(Arrays.asList(i,j));
                }
            }
        }
        return result;
    }
    
    private void dfs(int i, int j, int rows, int cols, boolean[][] visited, int prevHeight, int[][] heights){
        if(i<0 || i>=rows || j<0 || j>=cols || visited[i][j] || prevHeight>heights[i][j]){
            return;
        }
        
        visited[i][j] = true;
        
        dfs(i+1,j,rows,cols,visited,heights[i][j],heights);
        dfs(i-1,j,rows,cols,visited,heights[i][j],heights);
        dfs(i,j-1,rows,cols,visited,heights[i][j],heights);
        dfs(i,j+1,rows,cols,visited,heights[i][j],heights);
    }
}