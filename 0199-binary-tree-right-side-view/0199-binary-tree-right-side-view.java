class Solution {
    int maxLevel=0;
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        dfs(root,1,ans);
        return ans;
}
     void dfs(TreeNode root, int depth, List<Integer> ans){
        if(root==null){
            return;
        }
        if(maxLevel<depth){
            ans.add(root.val);
            maxLevel=depth;
        }
        dfs(root.right,depth+1,ans);
        dfs(root.left,depth+1,ans);
    }
}