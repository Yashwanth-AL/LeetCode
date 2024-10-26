class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {

        Map<String, Integer> map = new HashMap<>();
        addWords(map, s1);
        addWords(map, s2);

        ArrayList<String> list = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            if(entry.getValue() == 1){
                list.add(entry.getKey());
            }
        }
        return list.toArray(new String[0]);
    }

    public void addWords(Map<String, Integer> map, String s){
        for(String str : s.split(" ")){
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
    }
}
