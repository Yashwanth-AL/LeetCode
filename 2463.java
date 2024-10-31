class Solution {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {

        Collections.sort(robot);
        Arrays.sort(factory, (a, b) -> Integer.compare(a[0], b[0]));

        int numRobots = robot.size();
        int numFactories = factory.length;
        long dp[][] = new long[numRobots + 1][numFactories + 1];

        for(int i = 1; i <= numRobots; i++){
            Arrays.fill(dp[i], Long.MAX_VALUE);
        }

        for(int i = 0; i <= numFactories; i++){
            dp[0][i] = 0;
        }

        for(int j = 1; j <= numFactories; j++){
            for(int i = 0; i <= numRobots; i++){
                dp[i][j] = dp[i][j-1];

                long totalDistance = 0;
                for(int k = 1; k <= Math.min(factory[j-1][1], i); k++){
                    long distance = Math.abs(factory[j-1][0] - robot.get(i-k));
                    if(distance + totalDistance <= Long.MAX_VALUE){
                        totalDistance += distance;
                    } else {
                        break;
                    }
                    if(dp[i-k][j-1] != Long.MAX_VALUE){
                        long candidate = dp[i-k][j-1] + totalDistance;
                        if(candidate < Long.MAX_VALUE){
                            dp[i][j] = Math.min(candidate, dp[i][j]);
                        }
                    }
                }
            }
        }
        return dp[numRobots][numFactories];
    }
}


//very difficult to answer using dynamic programming revision is needed for this problem
