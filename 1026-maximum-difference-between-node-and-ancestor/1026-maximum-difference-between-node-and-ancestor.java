class Solution {
    private int helper(TreeNode root, int max, int min){
        if(root==null) return max-min;

        max = Math.max(max, root.val);
        min = Math.min(min, root.val);

        return Math.max(helper(root.left, max, min), helper(root.right, max, min));
    }
    
    public int maxAncestorDiff(TreeNode root) {
        return helper(root, root.val, root.val);
    }
}