class Solution {
    public int smallestChair(int[][] times, int targetFriend) {

       int n = times.length;
       int[][] people = new int[n][3];
       for(int i = 0; i < n; i++){
            people[i][0] = times[i][0];
            people[i][1] = times[i][1];
            people[i][2] = i;
       }

       Arrays.sort(people, (a, b) -> Integer.compare(a[0], b[0]));

       PriorityQueue<Integer> available = new PriorityQueue<>();
       for(int i = 0; i < n; i++){
            available.add(i);
       }
       PriorityQueue<int[]> occupied = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        //[departureTime, chairNumber]

       for(int[] person : people){
            int arrivalTime = person[0];
            int departureTime = person[1];
            int index = person[2];

            while(!occupied.isEmpty() && occupied.peek()[0] <= arrivalTime){
                int[] removed = occupied.poll();
                available.add(removed[1]);
            }

            int assigned = available.poll();
            if(index == targetFriend){
                return assigned;
            }

            occupied.add(new int[] {departureTime, assigned});
       }
       return -1;
    }
}
