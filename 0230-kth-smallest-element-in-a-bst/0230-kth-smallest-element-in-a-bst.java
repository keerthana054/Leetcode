class Solution {
    int result;
    int count;
    public int kthSmallest(TreeNode root, int k) {
        result = 0;
        count = 0;
        inorderTraversal(root,k);
        return result;
    }
    private void inorderTraversal(TreeNode node, int k) {
        if (node == null || count >= k) {
            return;
        }

        inorderTraversal(node.left, k);

        count++;
        if (count == k) {
            result = node.val;
            return;
        }

        inorderTraversal(node.right, k);
}
}