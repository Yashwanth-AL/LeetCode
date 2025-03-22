class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        List<Integer>[] graph = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph[u].add(v);
            graph[v].add(u);
        }

        boolean[] visited = new boolean[n];
        int count = 0;

        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                List<Integer> nodes = new ArrayList<>();
                dfs(graph, i, visited, nodes);
                if(isComplete(graph, nodes)) {
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(List<Integer>[] graph, int start, boolean[] visited, List<Integer> nodes) {
        visited[start] = true;
        nodes.add(start);
        for(int neighbour : graph[start]) {
            if(!visited[neighbour]) {
                dfs(graph, neighbour, visited, nodes);
            }
        }
    }

    private boolean isComplete(List<Integer>[] graph, List<Integer> nodes) {
        int size = nodes.size();
        for(int node : nodes) {
            if(graph[node].size() != size - 1) {
                return false;
            }
        }
        return true;
    }
}
