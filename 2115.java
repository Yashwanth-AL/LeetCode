import java.util.*;

public class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String, Integer> indegree = new HashMap<>();
        Map<String, List<String>> graph = new HashMap<>();
        Set<String> supplySet = new HashSet<>(Arrays.asList(supplies));
        List<String> result = new ArrayList<>();

        // Initialize graph and indegree
        for (int i = 0; i < recipes.length; i++) {
            String recipe = recipes[i];
            indegree.put(recipe, ingredients.get(i).size());
            for (String ing : ingredients.get(i)) {
                graph.computeIfAbsent(ing, k -> new ArrayList<>()).add(recipe);
            }
        }

        // Perform topological sort
        Queue<String> queue = new LinkedList<>(supplySet);
        while (!queue.isEmpty()) {
            String item = queue.poll();
            if (indegree.containsKey(item) && indegree.get(item) == 0) {
                result.add(item);
            }
            if (!graph.containsKey(item)) continue;
            for (String next : graph.get(item)) {
                indegree.put(next, indegree.get(next) - 1);
                if (indegree.get(next) == 0) {
                    queue.add(next);
                }
            }
        }
        return result;
    }
}
