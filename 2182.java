class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        HashMap<Character, Integer> map = new HashMap<>();

        for(char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = 
                new PriorityQueue<>((a, b) -> b.getKey() - a.getKey());

        maxHeap.addAll(map.entrySet());

        StringBuilder result = new StringBuilder();

        while(!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> current = maxHeap.poll();
            char currentChar = current.getKey();
            int count = current.getValue();

            int limit = Math.min(repeatLimit, count);
            for(int i = 0; i < limit; i++) {
                result.append(currentChar);
            }

            if(count > limit) {

                if (maxHeap.isEmpty()) break;

                Map.Entry<Character, Integer> next = maxHeap.poll();
                result.append(next.getKey());
                if(next.getValue() > 1) {
                    next.setValue(next.getValue() - 1);
                    maxHeap.offer(next);
                }

                current.setValue(count - limit);
                maxHeap.offer(current);
            }
        }
        return result.toString();
    }
}
