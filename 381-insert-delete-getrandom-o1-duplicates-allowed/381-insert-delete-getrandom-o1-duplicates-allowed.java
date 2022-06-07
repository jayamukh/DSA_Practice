class RandomizedCollection {
    
    ArrayList<Integer> lst;
    HashMap<Integer, Set<Integer>> idx;
    java.util.Random rand  = new  java.util.Random();

    public RandomizedCollection() {
        lst = new ArrayList<Integer>();
        idx = new HashMap<Integer, Set<Integer>>();
    }
    
    public boolean insert(int val) {
        if(!idx.containsKey(val)) idx.put(val, new LinkedHashSet<Integer>());
        idx.get(val).add(lst.size());
        lst.add(val);
        return idx.get(val).size() == 1;
    }
    
    public boolean remove(int val) {
        if(!idx.containsKey(val) || idx.get(val).size() == 0) return false;
        
        int remove_idx = idx.get(val).iterator().next();
        
        idx.get(val).remove(remove_idx);
        int last  = lst.get(lst.size()-1);
        //swap with last ele in list
        lst.set(remove_idx, last);
        
        idx.get(last).add(remove_idx);
        idx.get(last).remove(lst.size() -1);
        lst.remove(lst.size() -1);
        return true;
    }
    
    public int getRandom() {
        return lst.get(rand.nextInt(lst.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */