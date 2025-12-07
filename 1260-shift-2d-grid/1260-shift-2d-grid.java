class Solution {
    private void reverse(List<Integer> arr, int left, int right){
        while(left<right){
            int temp=arr.get(left);
            arr.set(left, arr.get(right));
            arr.set(right,temp);
            left++;
            right--;
        }
    }
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int size = m*n;
        List<Integer> oneDList = new ArrayList<>(size);
        for(int[] row:grid){
            for(int element:row){
                oneDList.add(element);
            }
        }
        k=k%size;

        reverse(oneDList, 0, size-1);
        reverse(oneDList,0,k-1);
        reverse(oneDList,k,size-1);
        List<List<Integer>> result=new ArrayList<>();
        int index=0;

        for(int i=0;i<m;i++){
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(oneDList.get(index++));
            }
            result.add(row);
        }

        return result;
    }
}