class NumberContainers {

    HashMap<Integer, Integer> map;  //index -> number mapping
    HashMap<Integer, TreeSet<Integer>> treeSet;    //number -> sorted index mapping

    public NumberContainers() {
        map = new HashMap<>();
        treeSet = new HashMap<>();
    }
    
    public void change(int index, int number) {
        if(map.containsKey(index)) {
           int oldNumber = map.get(index);
           treeSet.get(oldNumber).remove(index);
           if(treeSet.get(oldNumber).isEmpty()) {
                treeSet.remove(oldNumber);
           }
        }
        map.put(index, number);
        treeSet.putIfAbsent(number, new TreeSet<>());
        treeSet.get(number).add(index);
    }
    
    public int find(int number) {
        if(!treeSet.containsKey(number)){
            return -1;
        }
        return treeSet.get(number).first();
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */
