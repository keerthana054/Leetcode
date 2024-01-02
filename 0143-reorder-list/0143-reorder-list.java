class Solution {
    public ListNode reorderList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next; 
        }
        
        ListNode mid = slow;
        
        ListNode prev = null;
        ListNode curr = mid.next;
        
        while(curr != null) {
            ListNode next = curr.next;
            
            curr.next = prev;
            prev = curr;
            
            curr = next;
        }
        
        ListNode left = head;
        ListNode right = prev;
        
         ListNode nextL, nextR;
        while (left != null && right != null) {
            nextL = left.next;
            left.next = right;

            nextR = right.next;
            right.next = nextL;

            left = nextL;
            right = nextR;
        }
        mid.next = null;
        
        return head;
    }
}