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
    public ListNode swapNodes(ListNode head, int k) {
        
        ListNode curX = head;
        ListNode preX = null;
        
        ListNode curY = head;
        ListNode preY = null;
        
        
        int idx = 1;
        while(idx<k)
        {
            preX = curX;
            curX = curX.next;
            idx++;
        }
       System.out.println(curX.val);
        
        ListNode itr1 = head;
        int id = 0;
         while(itr1 != null)
         {
             itr1 = itr1.next;
             if(id >= k)
             {
                 preY = curY;
                 curY = curY.next;
             }
             id ++;
         }
        
        if(curX.val == curY.val)
            return head;
        
        
        // If x is not head of linked list
         if (preX != null)
            preX.next = curY;
        else // make y the new head
            head = curY;
 
        // If y is not head of linked list
        if (preY != null)
            preY.next = curX;
        else // make x the new head
            head = curX;
        
        
        ListNode temp = curX.next;
        curX.next = curY.next;
        curY.next = temp;
        
        
        return head;
    }
    
    
}