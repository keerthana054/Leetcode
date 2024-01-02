class Solution {
    public int[] processQueries(int[] queries, int m) {
        ArrayList<Integer> al = new ArrayList<>();
        for(int i=1;i<=m;i++) al.add(i);
        int ans[]=new int[queries.length];
        int idx=0;
        for(int i=0;i<queries.length;i++){
            ans[idx++]= al.indexOf(queries[i]) ;
            al.remove(al.indexOf(queries[i]));
            al.add(0,queries[i]);
        }
        return ans;

        
    }
}