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
   /* public Node flatten(Node head) {
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
    */
    
   public Node flatten(Node head)
   {
       if(head == null) return head;
       Node preHead = new Node(0, null, head, null);
       
       Node curr, prev  = preHead;
       Stack<Node> st  = new Stack<>();
       
       st.push(head);
       
       while(st.size() > 0)
       {
           curr = st.pop();
           curr.prev = prev;
           prev.next = curr;
           
           if(curr.next != null) st.push(curr.next);
           if(curr.child != null) 
           {
               st.push(curr.child);
               curr.child = null;
               
           }
           prev = curr;
       }
       
       preHead.next.prev = null;
       
       return head;
   }
    
}