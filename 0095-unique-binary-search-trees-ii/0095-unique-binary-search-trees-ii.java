class Solution {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode>[][] dp = new List[n + 1][n + 1];
        return f(1, n, dp);
    }
    private List<TreeNode> f(int low, int high, List<TreeNode>[][] dp){
        List<TreeNode> bst = new ArrayList<>();
        if (low > high){
            bst.add(null);
            return bst;
        }
        if (dp[low][high] != null)
            return dp[low][high];

        for (int i = low; i <= high; i++){
            List<TreeNode> leftSubTree = f(low, i - 1, dp);
            List<TreeNode> rightSubTree = f(i + 1, high, dp);
            for (TreeNode left : leftSubTree){
                for (TreeNode right : rightSubTree){
                    bst.add(new TreeNode(i, left, right));
                }
            }
        }
        return dp[low][high] = bst;
    }
}