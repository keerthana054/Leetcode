class Solution {
    int[] parent = new int[26];
    public Solution() {
        for(int i=0; i<26; i++){
            parent[i] = i;
        }
    }

    int find(int x){
        if(parent[x]!=x) parent[x] = find(parent[x]);
        return parent[x];
    }

    void union(int a, int b){
        int pa = find(a);
        int pb = find(b);

        if(pa==pb) return;
        if(pa<pb) parent[pb] = pa;
        else parent[pa]=pb;
    }
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        for(int i=0;i<s1.length();i++){
            union(s1.charAt(i)-'a', s2.charAt(i)-'a');
        }

        StringBuilder sb = new StringBuilder();
        for(char c : baseStr.toCharArray()){
            int root = find(c-'a');
            sb.append((char)(root+'a'));
        }
        return sb.toString();
        
    }
}