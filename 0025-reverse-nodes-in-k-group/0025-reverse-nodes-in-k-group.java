class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head==null || head.next==null) {
            return head;
        }
        if (check(head,k)) {    //Function to check if we have k more nodes after head node.
            return head;    //if lessthan k nodes just return it
        }
        ListNode th = head;
        ListNode dummy = null;
        ListNode t = head;
        int count = k;
        while (count>0 && head!=null) {
            t = head;
            head = head.next;
            t.next = dummy;
            dummy = t;
            count--;
        }
        th.next = head;
        ListNode x = reverseKGroup(head,k);
        th.next = x;
        return dummy;
    }
    public boolean check(ListNode head, int k) {
        while(k>0 && head!=null) {
            head = head.next;
            k--;
        }
        if (k==0) {
            return false;
        }
        return true;
    }
}