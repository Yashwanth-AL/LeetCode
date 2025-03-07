class Solution {
    public int[] closestPrimes(int left, int right) {
        ArrayList<Integer> list  = generatePrime(left, right);
        int[] result = new int[2];
        Arrays.fill(result, -1);

        if(list.size() >= 2) {
            int difference = list.get(1) - list.get(0);
            result[0] = list.get(0);
            result[1] = list.get(1);

            for(int i = 0; i < list.size() - 1; i++) {
                if(list.get(i + 1) - list.get(i) < difference) {
                    result[0] = list.get(i);
                    result[1] = list.get(i+1);
                    difference = list.get(i + 1) - list.get(i);
                }
            }
        }

        return result;

    }

    public ArrayList<Integer> generatePrime(int left, int right) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = left; i <= right; i++) {
            if(isPrime(i)) {
                list.add(i);
            }
        }
        return list;
    }

    public boolean isPrime(int num) {
        if(num <= 1) return false;
        for(int i = 2; i * i <= num; i++) {
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
