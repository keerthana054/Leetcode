class Solution {
    int sum = 0;

    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null) return sum;

        dfs(root, low, high);

        return sum;
    }

    private void dfs(TreeNode root, int low, int high){
        if(root == null) return;

        if(root.val > low) {
            dfs(root.left, low, high);
        }

        if(root.val >= low && root.val <= high){
            sum += root.val;
        }

        if(root.val < high) {
            dfs(root.right, low, high);
        }
    }
}