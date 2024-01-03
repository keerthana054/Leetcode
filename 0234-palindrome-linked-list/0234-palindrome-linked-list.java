class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode reverseSecondHalf = reverse(slow);
        while(reverseSecondHalf!=null){
            if(head.val!=reverseSecondHalf.val){
                return false;
                
            }reverseSecondHalf = reverseSecondHalf.next;
                head = head.next;
            
        }return true;
    }
    private ListNode reverse(ListNode head){
        ListNode preNode = null;
        ListNode currNode = head;

        while(currNode!=null){
            ListNode nextNode = currNode.next;
            currNode.next = preNode;
            preNode = currNode;
            currNode = nextNode;
        }
        return preNode;
    }
}