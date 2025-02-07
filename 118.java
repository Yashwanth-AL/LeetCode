class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();

        for(int i = 0; i < numRows; i++) {
            List<Integer> current = new ArrayList<>();
            current.add(1);

            for(int j = 1; j < i; j++) {
                int value = list.get(i-1).get(j-1) + list.get(i-1).get(j);
                current.add(value);
            }

            if(i > 0) {
                current.add(1);
            }
            list.add(current);
        }
        return list;
    }
}
