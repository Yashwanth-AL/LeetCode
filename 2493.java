import java.util.*;

class Solution {
    public int magnificentSets(int n, int[][] edges) {

        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        int[] color = new int[n + 1]; // 0: unvisited, 1: color A, -1: color B
        Arrays.fill(color, 0);
        int maxGroups = 0;

        for (int i = 1; i <= n; i++) {
            if (color[i] == 0) {
                List<Integer> component = new ArrayList<>();
                if (!bfsCheck(graph, color, i, component)) {
                    return -1; // Not bipartite
                }
                maxGroups += getMaxGroups(graph, component);
            }
        }
        return maxGroups;
    }

    private boolean bfsCheck(List<List<Integer>> graph, int[] color, int start, List<Integer> component) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        color[start] = 1; // Start coloring
        component.add(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : graph.get(node)) {
                if (color[neighbor] == 0) {
                    color[neighbor] = -color[node]; // Assign opposite color
                    queue.add(neighbor);
                    component.add(neighbor);
                } else if (color[neighbor] == color[node]) {
                    return false; // Odd cycle detected (not bipartite)
                }
            }
        }
        return true;
    }

    // Step 4: Compute the maximum BFS level in each component
    private int getMaxGroups(List<List<Integer>> graph, List<Integer> component) {
        int maxLevels = 0;
        for (int node : component) {
            maxLevels = Math.max(maxLevels, bfsMaxDepth(graph, node));
        }
        return maxLevels;
    }

    private int bfsMaxDepth(List<List<Integer>> graph, int start) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(start);
        visited.add(start);
        int depth = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            for (int i = 0; i < size; i++) {
                int node = queue.poll();
                for (int neighbor : graph.get(node)) {
                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        queue.add(neighbor);
                    }
                }
            }
        }
        return depth;
    }
}
