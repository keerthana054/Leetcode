class Solution {
	int[] colors;
    public boolean isBipartite(int[][] graph) {
        HashMap<Integer, ArrayList<Integer>> adj = new HashMap<Integer, ArrayList<Integer>>();
		colors = new int[graph.length];
		
		for (int i = 0; i < graph.length; i++) {
			adj.putIfAbsent(i, new ArrayList<Integer>());
			for(int j=0;j<graph[i].length;j++){
                adj.get(i).add(graph[i][j]);
            }
		}
		
		for (int i = 0; i < colors.length; i++) {
			if(colors[i]==0 && adj.get(i)==null) {
				colors[i]=1;
			}
			else if(colors[i]==0 && !(adj.get(i)==null)) {
				if(!bfs(adj, i)) {
					return false;
				}
			}
		}
		return true;
	}
	
	private boolean bfs(HashMap<Integer, ArrayList<Integer>> adj, int node) {
		ArrayList<Integer> que = new ArrayList<Integer>();
		que.add(node);
		colors[node] = 1;
		int c =0;
		while(que.size()>0) {
			
			for(int i=0;i<adj.get(que.get(0)).size();i++) {
				if(colors[adj.get(que.get(0)).get(i)]==0) {
					if(colors[que.get(0)]==1) {
						colors[adj.get(que.get(0)).get(i)] = 2;
						que.add(adj.get(que.get(0)).get(i));
					}
					else if(colors[que.get(0)]==2) {
						colors[adj.get(que.get(0)).get(i)] = 1;
						que.add(adj.get(que.get(0)).get(i));
					}
				}
				else {
					if(colors[que.get(0)]==colors[adj.get(que.get(0)).get(i)]) {
						return false;
					}
					
				}
            }
			que.remove(0);
		}
		return true	;
	}
}