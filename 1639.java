class Solution {
    public int numWays(String[] words, String target) {
        int MOD = 1_000_000_007;
        int m = words[0].length();
        int n = target.length();

        int freq[][] = new int[26][m];
        for(String word : words) {
            for(int j = 0; j < m; j++) {
                freq[word.charAt(j) - 'a'][j]++;
            }
        }

        long dp[][] = new long[n+1][m+1];
        for(int j = 0; j <= m; j++) {
            dp[0][j] = 1;
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++){
                dp[i][j] = dp[i][j-1];

                char targetChar = target.charAt(i-1);
                if(freq[targetChar - 'a'][j-1] > 0) {
                    dp[i][j] += freq[targetChar - 'a'][j-1] * dp[i-1][j-1];
                    dp[i][j] %= MOD;
                }
            }
        }

        return (int) dp[n][m];
    }
}
