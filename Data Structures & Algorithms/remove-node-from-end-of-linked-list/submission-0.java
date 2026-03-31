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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        Map<Integer, ListNode> nodePos = new HashMap<>();
        int length = 0;
        while (head != null) {
            nodePos.put(length, head);
            head = head.next;
            length++;
        }
        int toRemovePos = length - n;
        ListNode dummy = new ListNode();
        ListNode copy = dummy;
        for (int i = 0; i < length; i++){
            if (i == toRemovePos) {
                continue;
            }
            copy.next = nodePos.get(i);
            copy = copy.next;
        }
        copy.next = null;

        return dummy.next;

    }
}
