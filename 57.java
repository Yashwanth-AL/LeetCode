class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();

        for(int interval[] : intervals) {
            if(interval[1] < newInterval[0]) {
                list.add(new int[]{interval[0], interval[1]});
            }else if(newInterval[1] < interval[0]) {
                list.add(new int[]{newInterval[0], newInterval[1]});
                newInterval[0] = interval[0];
                newInterval[1] = interval[1];
            } else {
                newInterval[0] = Math.min(newInterval[0], interval[0]);
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }
        }
        list.add(new int[]{newInterval[0], newInterval[1]});
        int[][] result = list.toArray(new int[0][]);
        return result;
    }
}
