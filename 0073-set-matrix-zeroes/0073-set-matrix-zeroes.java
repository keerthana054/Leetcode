class Solution {
    public void setZeroes(int[][] matrix) {
        ArrayList<Integer> row=new ArrayList();
        ArrayList<Integer> column=new ArrayList();
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                if(matrix[i][j]==0){
                    row.add(i);
                    column.add(j);
                }
            }
        }
        for(int x:row){
            for(int i=0;i<matrix[0].length;i++){
                matrix[x][i]=0;
            }
        }
        for(int y:column){
            for(int i=0;i<matrix.length;i++){
                matrix[i][y]=0;
            }
        }
    }
}