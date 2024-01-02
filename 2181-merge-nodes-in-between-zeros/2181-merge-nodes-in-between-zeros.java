class Solution {
    public ListNode mergeNodes(ListNode head) {
        ListNode node = head.next;
        ListNode n = new ListNode();
        head = n;
        int sum = 0;
        
        while(node!=null){
            if(node.val == 0){
                n.next = new ListNode(sum);
                n = n.next;
                sum = 0;
            }
            else{
                sum+=node.val;
            }
            node = node.next;
        }
        return head.next;
    }
}