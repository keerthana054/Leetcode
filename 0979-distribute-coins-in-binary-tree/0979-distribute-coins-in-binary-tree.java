class Solution {
    private int moves;

    public int distributeCoins(TreeNode root) {
        moves = 0;
        dfs(root);
        return moves;
    }

    private int dfs(TreeNode current) {
        if (current == null)
            return 0;
        int leftCoins = dfs(current.left);
        int rightCoins = dfs(current.right);
        moves += Math.abs(leftCoins) + Math.abs(rightCoins);
        return (current.val - 1) + leftCoins + rightCoins;
    }
}