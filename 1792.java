class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {

        PriorityQueue<double[]> maxHeap = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));

        for(int[] c : classes) {
            int passed = c[0], total = c[1];
            double gain = calculateGain(passed, total);
            maxHeap.offer(new double[]{gain, passed, total});
        }

        while(extraStudents > 0){
            double top[] = maxHeap.poll();
            int passed = (int) top[1] + 1; 
            int total = (int) top[2] + 1;
            double gain = calculateGain(passed, total); 
            maxHeap.offer(new double[]{gain, passed, total}); 
            extraStudents--;
        }

        double totalRatio = 0.0;
        while (!maxHeap.isEmpty()) {
            double[] top = maxHeap.poll();
            totalRatio += (top[1] / top[2]); 
        }

        return totalRatio / classes.length;
    }

    private double calculateGain(int passed, int total) {
        return ((double) (passed + 1) / (total + 1)) - ((double) passed / total);
    }
}
