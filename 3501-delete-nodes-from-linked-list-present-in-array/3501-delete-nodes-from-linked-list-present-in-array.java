/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> ValuesToRemove = new HashSet<>();

        for (int value : nums ) {
            ValuesToRemove.add(value);
        }

        ListNode dummyHead = new ListNode(0, head);

        for ( ListNode pre = dummyHead; pre.next != null; ) {
            if (ValuesToRemove.contains(pre.next.val)) {
                pre.next = pre.next.next;
            }
            else {
                pre = pre.next;
            }
        }

        return dummyHead.next;
    }
}