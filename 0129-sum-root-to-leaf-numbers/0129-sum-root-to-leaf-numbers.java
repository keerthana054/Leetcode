class Solution {
    int ans = 0;
    public int sumNumbers(TreeNode root) {
        helper(root,0);
        return ans;
    }
    void helper(TreeNode root,int sum){
        if(root==null){
            return;
        }
        sum = sum * 10 + root.val;
        if(root.left==null && root.right==null){
            ans = ans + sum;
        }
        helper(root.left,sum);
        helper(root.right,sum);
    }
}