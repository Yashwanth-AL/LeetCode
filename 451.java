class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> freq = new HashMap<>();
        for(char ch : s.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Character> heap = new PriorityQueue<>((a, b) -> freq.get(b) - freq.get(a));
        heap.addAll(freq.keySet());

        StringBuilder result = new StringBuilder();
        while(!heap.isEmpty()) {
            char ch = heap.poll();
            int count = freq.get(ch);
            for(int i = 0; i < count; i++) {
                result.append(ch);
            }
        }
        return result.toString();
    }
}
