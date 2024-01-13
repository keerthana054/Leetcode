class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        int l = 0;
        int r = nums.length-1;
        return CreateNode(nums, l, r);
    }

    private TreeNode CreateNode(int[] nums,int l,int r){

        if(l>r){
            return null;
        }

        int mid = (l+r)/2;
        TreeNode root = new TreeNode(nums[mid]);

        root.left = CreateNode(nums, l, mid-1);
        root.right = CreateNode(nums, mid+1, r);

        return root;
    }
}