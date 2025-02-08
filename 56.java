class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> list = new ArrayList<>();
        int current[] = intervals[0];
        list.add(current);

        for(int interval[] : intervals) {
            int start = interval[0];
            int end = interval[1];

            if(current[1] >= start) {
                current[1] = Math.max(current[1], end);
            } else {
                current = interval;
                list.add(interval);
            }
        }
        return list.toArray(new int[list.size()][2]);
    }
}
