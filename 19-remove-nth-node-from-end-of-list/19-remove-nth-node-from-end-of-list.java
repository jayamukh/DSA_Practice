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
        ListNode temp1 = head;
        ListNode iter1 = head;
        ListNode iter2 = head;
        int i = 0;
        while(iter1.next != null)
        {
            iter1 = iter1.next;
            i++;
            if(i > n)
                iter2 = iter2.next;            
        }
        
        if(i < n-1)
            return head;
        else if(i == n-1)
        {
            //delete head
            head = head.next;
            return head;
        }
        else
        {
        ListNode temp = iter2.next;
        iter2.next = iter2.next.next;
        temp.next = null;
            return head;
        }
        
    }
}