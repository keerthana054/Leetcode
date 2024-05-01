import java.util.*;

class Solution {
    public int removeStones(int[][] stones) {
        UnionFind uf = new UnionFind();

        for (int[] stone : stones) {
            uf.union(stone[0], ~stone[1]);
        }

        Set<Integer> uniqueComponents = new HashSet<>();
        for (int[] stone : stones) {
            uniqueComponents.add(uf.find(stone[0]));
        }

        return stones.length - uniqueComponents.size();
    }

    class UnionFind {
        Map<Integer, Integer> parent;

        public UnionFind() {
            parent = new HashMap<>();
        }

        public int find(int x) {
            if (!parent.containsKey(x)) {
                parent.put(x, x);
            } else if (parent.get(x) != x) {
                parent.put(x, find(parent.get(x)));
            }
            return parent.get(x);
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                parent.put(rootX, rootY);
            }
        }
    }
}
