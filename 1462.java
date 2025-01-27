class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        int m = numCourses;
        int graph[][] = new int[m][m];
        for(int arr[] : prerequisites) {
            int start = arr[0];
            int end = arr[1];
            graph[start][end] = 1;
        }

        List<Boolean> result = new ArrayList<>();

        for(int[] query : queries) {
            int start = query[0];
            int end = query[1];
            int visited[] = new int[m];
            result.add(dfs(graph, start, end, visited));
        }
        return result;
    }

    public boolean dfs(int[][] graph, int start, int end, int[] visited) {
        if(visited[start] == 0){
            visited[start] = 1;
        } 
        if(visited[end] == 1) {
            return true;
        }
        for(int i = 0; i < graph.length; i++) {
            if(graph[start][i] == 1 && visited[i] == 0){
                dfs(graph, i, end, visited);
            }
        }
        if(visited[end] == 1) {
            return true;
        }
        return false;
    }
}
