class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        
        if (root == null) {
            return result;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean zigzag = false; // flag to determine zigzag order
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();
            Stack<Integer> tempStack = new Stack<>(); // for storing values in reverse order
            
            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();
                
                if (zigzag) {
                    tempStack.push(current.val);
                } else {
                    currentLevel.add(current.val);
                }
                
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
            
            // Add values to the result list in the desired order
            if (zigzag) {
                while (!tempStack.isEmpty()) {
                    currentLevel.add(tempStack.pop());
                }
            }
            
            result.add(currentLevel);
            zigzag = !zigzag; // toggle the zigzag flag for the next level
        }
        
        return result;
    }
}