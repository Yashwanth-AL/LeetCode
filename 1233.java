class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        List<String> list = new ArrayList<>();

        String previous = "";
        for(String f : folder){
            if(previous == "" || !f.startsWith(previous + "/")){
                list.add(f);
                previous = f;
            }
        }
        return list;
    }
}
