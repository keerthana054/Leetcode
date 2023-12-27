
class Solution {
    public TreeNode reference;
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        dfs(original, cloned, target);
        return reference;
    }
    public void dfs(TreeNode original, TreeNode cloned, TreeNode target) {
        if(original == null) return;
        if(original.val == target.val) this.reference = cloned;
        dfs(original.left, cloned.left, target);
        dfs(original.right, cloned.right, target);
    }
}