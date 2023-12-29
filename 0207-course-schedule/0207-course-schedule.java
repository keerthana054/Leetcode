class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Handle edge case: only one course, so it's always possible
        if (numCourses == 1) {
            return true;
        }

        // Create adjacency list to represent course dependencies
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        // Build adjacency list and calculate in-degrees
        int[] inDegree = new int[numCourses];
        for (int[] pre : prerequisites) {
            // Add edge from prerequisite to course
            adj.get(pre[1]).add(pre[0]);
            // Increment in-degree of course
            inDegree[pre[0]]++;
        }

        // Perform topological sorting using BFS
        Queue<Integer> q = new LinkedList<>();
        // Enqueue courses with in-degree 0 (no prerequisites)
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }

        ArrayList<Integer> topoSeries = new ArrayList<>(); // Store topological order
        while (!q.isEmpty()) {
            int node = q.remove();
            topoSeries.add(node);
            // Update in-degrees of dependent courses
            for (int neighbor : adj.get(node)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    // Enqueue course if it has no more prerequisites
                    q.add(neighbor);
                }
            }
        }

        // If topological order contains all courses, then it's possible to complete them
        return topoSeries.size() == numCourses;
    }
}