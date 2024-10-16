class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((p, q) -> q[1] - p[1]);

        if (a > 0) heap.add(new int[] {'a', a});
        if (b > 0) heap.add(new int[] {'b', b});
        if (c > 0) heap.add(new int[] {'c', c});

        StringBuilder result = new StringBuilder();

        while(!heap.isEmpty()){
            int first[] = heap.poll();
            char firstChar = (char) first[0];

            int length = result.length();
            if(length >= 2 && result.charAt(length-1) == firstChar && result.charAt(length - 2) == firstChar){

                if(heap.isEmpty()) break;

                int second[] = heap.poll();
                char secondChar = (char) second[0];
                second[1]--;
                result.append(secondChar);
                
                if(second[1] > 0) heap.add(second);
                heap.add(first);

            } else {

                result.append(firstChar);
                first[1]--;
                if(first[1] > 0) heap.add(first);

            }
        }
        return result.toString();
    }
}
