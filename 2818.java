import java.util.*;

class Solution {
    private static final int MOD = 1_000_000_007;
    
    public int maximumScore(List<Integer> nums, int k) {
        int n = nums.size();
        // Each entry in 'arr' stores: { index, primeScore, value }
        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            int value = nums.get(i);
            arr[i] = new int[] { i, primeFactors(value), value };
        }
        
        // left[i] = previous index with primeScore >= current primeScore, or -1 if none
        int[] left = new int[n];
        // right[i] = next index with primeScore > current primeScore, or n if none
        int[] right = new int[n];
        Arrays.fill(left, -1);
        Arrays.fill(right, n);
        
        Deque<Integer> stack = new ArrayDeque<>();
        // Find previous indices where primeScores are >= current one.
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()][1] < arr[i][1]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                left[i] = stack.peek();
            }
            stack.push(i);
        }
        
        stack.clear();
        // Find next indices where primeScores are > current one.
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()][1] <= arr[i][1]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                right[i] = stack.peek();
            }
            stack.push(i);
        }
        
        // Sort indices by the actual value in descending order.
        Arrays.sort(arr, (a, b) -> b[2] - a[2]);
        
        long ans = 1;
        for (int[] e : arr) {
            int i = e[0], x = e[2];
            // The count of subarrays where nums[i] is chosen:
            long count = (long)(i - left[i]) * (right[i] - i);
            if (count <= k) {
                ans = ans * qpow(x, count) % MOD;
                k -= count;
            } else {
                ans = ans * qpow(x, k) % MOD;
                break;
            }
        }
        return (int) ans;
    }
    
    // Returns the number of distinct prime factors of n.
    private int primeFactors(int n) {
        int i = 2;
        Set<Integer> factors = new HashSet<>();
        while (i <= n / i) {
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
            i++;
        }
        if (n > 1) {
            factors.add(n);
        }
        return factors.size();
    }
    
    // Fast power mod function: computes (a^n) % MOD.
    private int qpow(long a, long n) {
        long res = 1;
        while (n > 0) {
            if ((n & 1) == 1) {
                res = res * a % MOD;
            }
            a = a * a % MOD;
            n >>= 1;
        }
        return (int) res;
    }
}
