class Solution {
    int sum = 0;
    int levelSum = 0;
    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> que = new LinkedList();
        que.add(root);
        while(!que.isEmpty()) {
            int currentLevelNodes = que.size();
            for(int i = 0; i < currentLevelNodes; i++) {
                TreeNode node = que.remove();
                if(node.left == null && node.right == null) {
                    levelSum += node.val;
                }
                if(node.left != null) {
                    que.add(node.left);
                }
                if(node.right != null) {
                    que.add(node.right);
                }
            }
            sum = levelSum;
            levelSum = 0;
        }
        return sum;
    }
}