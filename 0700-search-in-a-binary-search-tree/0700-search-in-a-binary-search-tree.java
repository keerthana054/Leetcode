class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode answer = new TreeNode();
        if(root == null)
 {
     return null;
 }
 
 if(root.val == val)
 {
     return root;
 }
 if(root.val > val)
 {
      answer=searchBST(root.left,val);
 }
 else{
      answer=searchBST(root.right,val);
     
 }
 return answer;

    }
}