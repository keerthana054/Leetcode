class Solution {
    public List<List<Integer>> kSmallestPairs(int[] A, int[] B, int k) {
        int n = A.length;
        int m = B.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->(a[0] - b[0]));
        HashSet<Pair<Integer,Integer>>hashSet = new HashSet<>();
        List<List<Integer>> ans = new ArrayList<>();
        int i,j;
        pq.add(new int[]{A[0]+B[0],0,0});
        hashSet.add(new Pair<Integer, Integer>(0, 0));
        while (!pq.isEmpty() && k-->0){
            int [] min = pq.remove();
            i = min[1];
            j = min[2];
            ans.add(Arrays.asList(A[i],B[j]));
            if(i<n-1 && !hashSet.contains(new Pair<Integer, Integer>(i+1,j))){
                pq.offer(new int[]{A[i+1]+B[j],i+1,j});
                hashSet.add(new Pair<Integer, Integer>(i+1,j));;
            }

            if(j<m-1 && !hashSet.contains(new Pair<Integer, Integer>(i,j+1))){
                pq.offer(new int[]{A[i]+B[j+1],i,j+1});
                hashSet.add(new Pair<Integer, Integer>(i,j+1));
            }
        }
        return ans;
    }
}