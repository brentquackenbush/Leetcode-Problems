public class CoinChangeII {
    public static void main(String[] args) {
        int amount = 5;
        int[] coins = {1,2,5};
        System.out.println(coinChange(amount,coins));
    }

    private static int coinChange(int amount, int[] coins) {

        int[] dp = new int[amount+1];
        dp[0] = 1;
        for(int coin: coins) {
            for(int i = coin; i <= amount; i++) {
                dp[i] += dp[i-coin];
            }
        }
        return dp[amount];

    }
}
