class LRUCache {
    
    class Node{
        int Key;
        int Val;
        Node next;
        Node prev;
        public Node(int key, int val)
        {
            this.Key = key;
            this.Val = val;
        }
        
    }
    
    Node head = null;
    Node tail = null;
    int size  = 0;
    int maxSize = 0;
    HashMap<Integer, Node> map;
    public void addLast(Node node)
        {
            if(size == 0)
            {
               head  = node;
                tail = node;
            }
        else
        {
            node.prev = tail;
            tail.next = node;
            node.next = null;
            tail = node;
            
        }
          size++;  
        }
        
        public void removeNode(Node node)
        {
            if(size == 1)
            {
                head = tail = null;
            }
            else if(node == head)
            {
                head = head.next;                
                head.prev = null;
                node.next = null;
            }
            else if(node == tail)
            {
                tail = tail.prev;
                 tail.next = null;
                node.prev = null;
            }
            else
            {
                Node prev  = node.prev;
                Node next  = node.next;
                prev.next = next;
                next.prev = prev;               
            
                node.prev = null;
                node.next = null;
            }
            size--;
        }
    
    public LRUCache(int capacity) {
        map  = new HashMap<>();
        maxSize = capacity;
    }
    
    public int get(int key) {
        if(!map.containsKey(key))
        {
            return -1;
        }
        else
        {
            Node val  = map.get(key);
            removeNode(val);
            addLast(val);
            return val.Val;
        }
    }
    
    public void put(int key, int value) {
        
        if(!map.containsKey(key))
        {
            Node node  = new Node(key, value);
            //add
            map.put(key,node);
            addLast(node);
            if(size > maxSize)
            {
                Node tr = head;
                removeNode(tr);
                map.remove(tr.Key);
            }
            
        }
        else
        {
            Node val  = map.get(key);           
            removeNode(val);
            addLast(val);
             val.Val = value;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */