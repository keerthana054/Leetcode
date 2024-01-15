class Solution {
    TreeNode pre;
    boolean result;
    public boolean isValidBST(TreeNode root) {
        pre = null;
        result = true;
        help(root);
        
        return result;
    }
    
    private void help(TreeNode root) {
        if(root == null) return;
        help(root.left);
        if(pre != null && pre.val >= root.val) result = false;
        pre = root;
        help(root.right);
    }
}