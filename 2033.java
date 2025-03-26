class Solution {
    public int minOperations(int[][] grid, int x) {
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int[] row : grid) {
            for(int val : row) {
                list.add(val);
            }
        }

        Collections.sort(list);
        int size = list.size();
        int median = list.get(size / 2);
        
        int operations = 0;
        for(int num : list) {
            if ((num - median) % x != 0) {
                return -1;
            }
            operations += Math.abs((num - median) / x);
        }
         
        return operations;
    }
}
