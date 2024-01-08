class Solution {
    public boolean isCompleteTree(TreeNode root) {
        if(root==null){
            return true;
        }
        boolean nullfound = false;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
             while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode temp=q.poll();
                if(temp==null)
                {
                    nullfound=true;
                }
                else {
                    if(nullfound)
                    {
                        return false;
                    }
                    else{
                        q.offer(temp.left);
                        q.offer(temp.right);

                    }
                }
                

            }

        }

        return true;
        }
    }
