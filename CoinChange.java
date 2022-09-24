class CoinChange {

    public static void main(String[] args) {
        int[] coins = new int[]{1,5,10,25};
        int amount = 111; //25 + 25 + 25 + 25 + 10 + 1 min = 6 amount of coins
        System.out.println(coinChange(coins,amount));
    }

    public static int coinChange(int[] coins, int amount) {
        int dp[] = new int[amount+1];
        for(int i=1;i<=amount;i++){
            int min = Integer.MAX_VALUE;
            for(int coin:coins){
                if(i-coin>=0 && dp[i-coin] != -1)
                    min = Math.min(dp[i - coin], min);
            }
            // Set dp[i] to -1 if i (current amount) can not be reach by  coins array
            dp[i] = min== Integer.MAX_VALUE ? -1 : 1+min;
        }
        return dp[amount];
    }
}