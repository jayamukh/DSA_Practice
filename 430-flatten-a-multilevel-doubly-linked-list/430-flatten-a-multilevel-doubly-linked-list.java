/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if(head == null) return head;
        
        Node preHead = new Node(0, null, head, null);
        
        dfsFlatten(preHead, head);
        
        preHead.next.prev = null;
        
        return head;
        
    }
    
    public Node dfsFlatten(Node prev, Node curr)
    {
        if(curr == null) return prev;
        curr.prev = prev;
        prev.next = curr;
        
        Node tempNext = curr.next;
        Node tail  = dfsFlatten(curr, curr.child);
        curr.child = null;
        return dfsFlatten(tail, tempNext);
        
    }
}