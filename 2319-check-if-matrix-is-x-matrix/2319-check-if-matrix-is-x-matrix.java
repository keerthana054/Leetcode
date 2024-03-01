class Solution {
    public boolean checkXMatrix(int[][] grid) {
        int[][] array=grid;
         boolean bool=false;
         for(int i=0; i<grid.length; i++){
             if(!(grid[i][i]!=0)) return false;
          
             if(!(grid.length%2!=0 && ((grid.length/2))==i)) grid[i][i]=0;
         }
       
         int count=0;
         for(int i=grid.length-1;i>=0; i--){
             if(!(grid[i][count]!=0)) return false;
             grid[i][count]=0;
             count++;
         }
       
        for(int[] a:grid){
            for(int ele:a){
                if(ele!=0) return false;
            }
        }
        return true;


    }
}