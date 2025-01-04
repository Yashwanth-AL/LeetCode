class Solution {
    public boolean isPathCrossing(String path) {
        Set<String> set = new HashSet<>();
        set.add("0,0");
        int x = 0, y = 0;
        
        for (char ch : path.toCharArray()) {
            if (ch == 'N') y++;
            else if (ch == 'S') y--;
            else if (ch == 'E') x++;
            else if (ch == 'W') x--;
            
            String position = x + "," + y;
            if (set.contains(position)) {
                return true;
            }
            set.add(position);
        }
        return false;
    }
}
