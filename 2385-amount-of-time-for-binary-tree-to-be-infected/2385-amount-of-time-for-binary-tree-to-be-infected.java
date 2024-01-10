class Solution {
  Map<Integer, Set<Integer>> graph = new HashMap<>();

  private void convert(TreeNode node, int parent) {
    graph.put(node.val, new HashSet<>());

    if (parent > 0)
      graph.get(node.val).add(parent);

    if (node.left != null) {
      graph.get(node.val).add(node.left.val);
      convert(node.left, node.val);
    }
    if (node.right != null) {
      graph.get(node.val).add(node.right.val);
      convert(node.right, node.val);
    }
  }

  public int amountOfTime(TreeNode root, int start) {
    convert(root, 0);

    var queue = new ArrayDeque<Integer>();
    queue.offer(start);

    var seen = new HashSet<>();
    var min = -1;
    
    while (!queue.isEmpty()) {
      for (var i = queue.size(); i > 0; i--) {
        var node = queue.poll();
        seen.add(node);

        for (var neighbor : graph.get(node))
          if (!seen.contains(neighbor))
            queue.offer(neighbor);
      }
      min++;
    }
    return min;
  }
}