class Solution {
    public int leastInterval(char[] tasks, int n) {
        int freq[] = new int[26];
        for(char ch : tasks) {
            freq[ch - 'A']++;
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        for(int f : freq) {
            if(f > 0) heap.add(f);
        }

        int time = 0;
        while(!heap.isEmpty()) {
            int cycles = 0;
            List<Integer> temp = new ArrayList<>();

            for(int i = 0; i <= n; i++) {
                if(!heap.isEmpty()) {
                    int val = heap.poll();
                    if(val > 1) temp.add(val - 1);
                    cycles++;
                }
            }

            for(int item : temp) {
                heap.add(item);
            }

            time += heap.isEmpty() ? cycles : n + 1;
        }
        return time;
    }
}
