class Solution {
    public int findChampion(int n, int[][] edges) {
       
        int indegree[] = new int[n];

        for(int edge[] : edges){
           indegree[edge[1]]++;
        }

        int count = 0;
        int node = -1;
        for(int i = 0; i < n; i++){
            if(indegree[i] == 0){
                count++;
                node = i;
            }
        }
        return count == 1 ? node : -1;
    }
}
