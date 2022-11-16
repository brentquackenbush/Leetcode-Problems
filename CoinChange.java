import java.util.Arrays;

class CoinChange {

    public static void main(String[] args) {
        int[] coins = new int[]{1,2,5};
        int amount = 11; //25 + 25 + 25 + 25 + 10 + 1 min = 6 amount of coins
        System.out.println(coinChange(coins,amount));
    }

    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0] = 0;

        for(int coin: coins) {
            for(int i = coin; i <= amount; i++) {
                dp[i] = Math.min(dp[i], dp[i-coin] + 1);
            }
        }

        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}