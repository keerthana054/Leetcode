class Solution {
    public Node connect(Node root) {
        populate(root);
        return root;
    }
    
    public void populate(Node root){
        
        if(root==null)
            return;
        if(root.left != null)
            root.left.next = root.right;
        if(root.right!=null && root.next !=null)
            root.right.next = root.next.left;
        
        populate(root.left);
        populate(root.right);
    }
}