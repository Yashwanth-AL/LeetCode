class Solution {

    private List<Integer>[] graph;
    private int maxDistance;
    private int farthestNode;

    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        int diameter1 = caluclateDiameter(edges1);
        int diameter2 = caluclateDiameter(edges2);
        int combined = (diameter1 + 1) / 2 + (diameter2 + 1) / 2 + 1;
        return Math.max(combined, Math.max(diameter1, diameter2));
    }

    private int caluclateDiameter(int[][] edges) {
        int n = edges.length + 1;
        graph = new List[n];
        Arrays.setAll(graph, list -> new ArrayList<>());
        for(int edge[] : edges){
            int u = edge[0];
            int v = edge[1];
            graph[u].add(v);
            graph[v].add(u);
        }
        maxDistance = 0;
        farthestNode = 0;
        dfs(0, -1, 0);
        dfs(farthestNode, -1, 0);
        return maxDistance;
    }

    private void dfs(int node, int parent, int distance) {
        for(int neighbour : graph[node]) {
            if(neighbour != parent) {
                dfs(neighbour, node, distance + 1);
            }
        }
        if(distance > maxDistance) {
            maxDistance = distance;
            farthestNode = node;
        }
    }
}
