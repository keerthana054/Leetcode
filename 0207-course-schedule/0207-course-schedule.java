class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 1) {
            return true;
        }

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        int[] inDegree = new int[numCourses];
        for (int[] pre : prerequisites) {
            adj.get(pre[1]).add(pre[0]);
            inDegree[pre[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }

        ArrayList<Integer> topoSeries = new ArrayList<>(); 
        while (!q.isEmpty()) {
            int node = q.remove();
            topoSeries.add(node);
            for (int neighbor : adj.get(node)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    q.add(neighbor);
                }
            }
        }
        return topoSeries.size() == numCourses;
    }
}