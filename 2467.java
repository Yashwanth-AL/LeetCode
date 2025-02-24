class Solution {
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n = amount.length;
        List<Integer>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        // Build the tree as an adjacency list
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        // Step 1: Compute Bob's exact path to the root
        int[] bobTime = new int[n];
        Arrays.fill(bobTime, Integer.MAX_VALUE);
        findBobPath(graph, bob, -1, 0, bobTime, new ArrayList<>());

        // Step 2: Alice's DFS to maximize profit
        return dfsAlice(graph, 0, -1, 0, 0, bobTime, amount);
    }

    private boolean findBobPath(List<Integer>[] graph, int node, int parent, int time, int[] bobTime, List<Integer> path) {
        path.add(node);
        if (node == 0) { // If Bob reaches root, mark all nodes in his path
            for (int i = 0; i < path.size(); i++) {
                bobTime[path.get(i)] = i;
            }
            return true;
        }

        for (int neighbor : graph[node]) {
            if (neighbor != parent && findBobPath(graph, neighbor, node, time + 1, bobTime, path)) {
                return true;
            }
        }

        path.remove(path.size() - 1);
        return false;
    }

    private int dfsAlice(List<Integer>[] graph, int node, int parent, int time, int profit, int[] bobTime, int[] amount) {
        // Compute Alice's profit at this node
        if (time < bobTime[node]) {
            profit += amount[node]; // Alice reaches first
        } else if (time == bobTime[node]) {
            profit += amount[node] / 2; // Alice and Bob reach at the same time
        }

        // If it's a leaf node, return the profit
        boolean isLeaf = true;
        int maxProfit = Integer.MIN_VALUE;

        for (int neighbor : graph[node]) {
            if (neighbor != parent) {
                isLeaf = false;
                maxProfit = Math.max(maxProfit, dfsAlice(graph, neighbor, node, time + 1, profit, bobTime, amount));
            }
        }

        return isLeaf ? profit : maxProfit;
    }
}
