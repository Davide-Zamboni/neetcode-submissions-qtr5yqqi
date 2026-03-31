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
    public void reorderList(ListNode head) {
        int length = 0;
        Map<Integer, ListNode> posMap = new HashMap<>();
        while (head != null){
            posMap.put(length, head);
            length++;
            head = head.next;
        }

        int start = 0;
        int end = length - 1;
        ListNode result = new ListNode();
        ListNode copy = result;

        while(start < end){
            copy.next = posMap.get(start);
            copy = copy.next;
            copy.next = posMap.get(end);
            copy = copy.next;
            start++;
            end --; 
        }

        if (start == end) {
            copy.next = posMap.get(start);
            copy = copy.next;
        }
        copy.next = null;
        head = result.next;
    }
}
