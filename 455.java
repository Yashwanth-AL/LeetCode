class Solution {
    public int findContentChildren(int[] g, int[] s) {
        if(s.length == 0 || g.length == 0) return 0;
        
        Arrays.sort(g);
        Arrays.sort(s);
        int result = 0;
        int index = 0;

        for(int i = 0; i < s.length; i++) {
            if(index < g.length && s[i] >= g[index]){
                result++;
                index++;
            } 
        }
        return result;
    }
}
