class Solution {
    static List<List<Integer>> ans;


    static void helper(int graph[][], int src, int dest, List<Integer> arr){
        if(src==dest){
            ans.add(new ArrayList(arr));
            return;
        }

        for(var a : graph[src]){
            arr.add(a);
            helper(graph,a,dest,arr);
            arr.remove(arr.size()-1);
        }
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        ans = new ArrayList<>();
        ArrayList<Integer> arr = new ArrayList<>();
        int n = graph.length;
        arr.add(0);

        helper(graph,0,n-1,arr);
        return ans;
    }
}