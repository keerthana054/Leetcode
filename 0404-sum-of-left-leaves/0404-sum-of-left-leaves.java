class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) return 0;

        int sum = 0;
        Stack<TreeNode> st = new Stack();
        st.add(root);

        while(!st.isEmpty()){
            TreeNode node = st.pop();

            if(node.left != null){
                if(node.left.left == null && node.left.right == null){
                    sum += node.left.val;
                }else{
                    st.add(node.left);
                }
            }

            if(node.right != null){
                if(node.right.left != null || node.right.right != null){
                    st.add(node.right);
                }
            }
        }

        return sum;
    }
}