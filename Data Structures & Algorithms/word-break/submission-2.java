class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean[] dp = new Boolean[s.length()];

        return solve(s, wordDict, 0, dp);
    }

    private boolean solve(String s, List<String> wordDict, int i, Boolean[] dp) {

        // Reached the end successfully
        if (i == s.length()) {
            return true;
        }

        // Already calculated
        if (dp[i] != null) {
            return dp[i];
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
                        dp[i] = true;
                        return true;
                    }
                }
            }
        }

        // No dictionary word worked from this position
        dp[i] = false;
        return false;
    }
}