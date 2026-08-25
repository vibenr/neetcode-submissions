class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1]; 

        Arrays.fill(dp, -1); 
        int ans = solve(coins, amount, dp); 

        return ans == Integer.MAX_VALUE ? -1 : ans; 
    }

    private int solve(int[] coins, int amount, int[] dp){

        // Exact amount reached
        if(amount == 0){
            return 0;
        }

         // Impossible
        if(amount < 0){
            return Integer.MAX_VALUE; 
        }

        if(dp[amount] != -1){
            return dp[amount]; 
        }

        int ans = Integer.MAX_VALUE; 

        for(int coin : coins){

            int result = solve(coins, amount - coin, dp); 
            System.out.println(result); 
            if(result != Integer.MAX_VALUE){
                ans = Math.min(ans, result + 1); 
            }
        }

        dp[amount] = ans; 
        return ans; 
    }
}
