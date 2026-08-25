class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int[] dp = new int[s.length() + 1];
        Arrays.fill(dp, -1); 

        return solve(s, wordDict, 0, dp);
    }

    private boolean solve(String s, List<String> wordDict, int i, int[] dp) {

        // Reached the end successfully
        if (i == s.length()) {
            return true;
        }

        // Already calculated
        if (dp[i] != -1) {
            return dp[i] == 1;
        }

        // Try every word
        for (String word : wordDict) {

            int len = word.length();

            // Make sure word fits inside the string
            if (i + len <= s.length()) {

                // Check whether the word matches starting at i
                if (s.substring(i, i + len).equals(word)) {

                    // If remaining string can be broken
                    if (solve(s, wordDict, i + len, dp)) {
                        dp[i] = 1;
                        return true;
                    }
                }
            }
        }

        // No dictionary word worked from this position
        dp[i] = 0;
        return false;
    }
}