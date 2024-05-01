class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid==null || grid.length==0){
            return -1;
        }
        
        Queue<int[]> queue = new LinkedList<>();
        int freshO = 0;
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    queue.offer(new int[]{i,j});
                }
                else if(grid[i][j]==1){
                    freshO++;
                }
            }
        }
        
        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
        int minutes = 0;
        
        while(!queue.isEmpty() && freshO>0){
            int size = queue.size();
            for(int i =0;i<size; i++){
                int current[] = queue.poll();
                for(int[] dir: directions){
                    int x = current[0] + dir[0];
                    int y = current[1] + dir[1];
                    if(x>=0 && x<grid.length && y>=0 && y<grid[0].length && grid[x][y]==1){
                        grid[x][y]=2;
                        freshO--;
                        queue.offer(new int[]{x,y});
                    }
                }
            }
            minutes++;
        }
        return freshO==0?minutes:-1;
    }
}