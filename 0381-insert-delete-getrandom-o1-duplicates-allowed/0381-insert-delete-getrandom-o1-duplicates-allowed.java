class RandomizedCollection {

    HashMap<Integer,Set<Integer>> map;
    ArrayList<Integer> list;

    public RandomizedCollection() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        list.add(val);
        int idx = list.size() - 1;
        Set<Integer> temp;
        if(map.containsKey(val) && map.get(val).size() != 0){
            temp = map.get(val);
            temp.add(idx);
            map.put(val,temp);
            return false;
        }else{
            temp = new HashSet<>();
            temp.add(idx);
            map.put(val,temp);
            return true;
        }
    }
    
    public boolean remove(int val) {

        if(!map.containsKey(val) || map.get(val).size() == 0) return false;

        Set<Integer> temp = map.get(val);
        int idx = temp.iterator().next();
        temp.remove(idx);
        map.put(val,temp);

        int curr = list.get(list.size()-1);
        list.set(idx,curr);
        temp = map.get(curr);
        temp.add(idx);
        temp.remove(list.size()-1);
        map.put(curr,temp);
        list.remove(list.size()-1);

        return true;
    }
    
    public int getRandom() {
        Random rand = new Random();
        int idx = rand.nextInt();
        int N = list.size();
        int index = (idx % N + N) % N;
        return list.get(index);
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */