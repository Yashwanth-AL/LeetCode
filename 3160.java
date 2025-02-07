class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        int[] result = new int[queries.length];
        Map<Integer, Integer> ballColor = new HashMap<>();
        Map<Integer, Integer> colorCount = new HashMap<>();
        int index = 0;

        for (int[] query : queries) {
            int ball = query[0];
            int color = query[1];

            if (ballColor.containsKey(ball)) {
                int prevColor = ballColor.get(ball);
                colorCount.put(prevColor, colorCount.get(prevColor) - 1);
                if (colorCount.get(prevColor) == 0) {
                    colorCount.remove(prevColor);
                }
            }

            ballColor.put(ball, color);
            colorCount.put(color, colorCount.getOrDefault(color, 0) + 1);

            result[index++] = colorCount.size();
        }
        return result;
    }
}
