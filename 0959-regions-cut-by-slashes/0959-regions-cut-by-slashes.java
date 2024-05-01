class Solution {
    private int[] uf;
    private int len;
    public int regionsBySlashes(String[] grid) {
        this.len = grid.length;
        this.uf = new int[len * 4 * len];
        for(int i = 0; i < len * len * 4; i++) uf[i] = i;
        for(int i = 0; i < len; i++){
            for(int j = 0; j < len; j++){
                char c = grid[i].charAt(j);
                int index = i * 4 * len + 4 * j;
                switch(c){
                    case ' ':
                        union(index, index + 1);
                        union(index + 1, index + 2);
                        union(index + 2, index + 3);
                        break;
                    case '/':
                        union(index, index + 3);
                        union(index + 1, index + 2);
                        break;
                    case '\\':
                        union(index, index + 1);
                        union(index + 2, index + 3);
                        break;
                }
                if(i + 1 < len) union(index + 2, index + 4 * len);
                if(j + 1 < len) union(index + 1, index + 4 + 3);
            }
        }
        int res = 0;
        for(int i = 0; i < len * len * 4; i++){
            if(uf[i] == i) res++;
        }
        return res;
    }
    private int find(int i){
        if(i != uf[i])
            uf[i] = find(uf[i]);
        return uf[i];
    }
    private void union(int i, int j){
        int p = find(i);
        int q = find(j);
        uf[p] = q;
    }
}