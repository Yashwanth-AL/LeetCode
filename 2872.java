class Solution {
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        // Graph representation
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        // Result to count k-divisible components
        int[] result = new int[1];

        // DFS traversal
        dfs(0, -1, graph, values, k, result);

        return result[0];
    }

    private long dfs(int node, int parent, List<List<Integer>> graph, int[] values, int k, int[] result) {
        // Use long to handle large sums
        long subtreeSum = values[node] % k;

        for (int neighbor : graph.get(node)) {
            if (neighbor != parent) { // Avoid revisiting the parent node
                subtreeSum += dfs(neighbor, node, graph, values, k, result);
                subtreeSum %= k; // Keep sum within mod bounds
            }
        }

        // If the current subtree sum is divisible by k, it forms a valid component
        if (subtreeSum % k == 0) {
            result[0]++;
            return 0; // Reset sum after forming a valid component
        }

        return subtreeSum; // Return the remainder for further computation
    }
}
