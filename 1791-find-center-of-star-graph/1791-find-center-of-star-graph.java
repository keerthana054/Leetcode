class Solution {
    public int findCenter(int[][] edges) {
        ArrayList<Integer> ar=new ArrayList<>();
        for(int x[]:edges)
        {
            ar.add(x[0]);
            ar.add(x[1]);
        }
        Collections.sort(ar);
        if(ar.get((ar.size()-3)/2)==ar.get((ar.size()-1)/2))
            return ar.get((ar.size()-1)/2);
        else
            return ar.get((ar.size())/2);
    }
}