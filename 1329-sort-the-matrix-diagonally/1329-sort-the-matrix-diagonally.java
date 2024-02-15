class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int arr[][]=new int[mat.length][mat[0].length];
        
        for(int i=0;i<mat[0].length;i++){
            ArrayList<Integer>list=new ArrayList<>();
            int ind=0;
            int ind1=i;
            while(ind<mat.length&&ind1<mat[0].length){
                list.add(mat[ind][ind1]);
                ind++;
                ind1++;
            }
            ind =0;
            ind1=i;
            Collections.sort(list);
            while(ind<mat.length&&ind1<mat[0].length){
                arr[ind][ind1]=list.get(ind);
                ind++;
                ind1++;
            }
        }
        for(int i=0;i<mat.length;i++){
            ArrayList<Integer>list=new ArrayList<>();
            int ind1=i;
            int ind=0;
            while(ind1<mat.length&&ind<mat[0].length){
                list.add(mat[ind1][ind]);
                ind1++;
                ind++;
            }
            Collections.sort(list);
            ind1=i;
            ind=0;
            while(ind1<mat.length&&ind<mat[0].length){
                arr[ind1][ind]=list.get(ind);
                ind1++;
                ind++;
            }
        }
        return arr;
    }
}