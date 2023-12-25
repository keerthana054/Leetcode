class Solution {
    public int ans = 0;
    public int goodNodes(TreeNode root) {
        traversal(root,root.val);
        return ans;
    }

    public void traversal(TreeNode root,int max){
        if(root == null){
            return ;
        }
        if(root.val>=max){
            ans++;
            max = root.val;  // for in between greater elements it is updated 
        }
        
        traversal(root.left,max);
        traversal(root.right,max);
        
    }
}