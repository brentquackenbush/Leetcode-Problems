public class UniquePaths {

    public static void main(String[] args) {
        int m = 3;
        int n = 7;
        //total paths should be 28
        System.out.println(totalPaths(m,n));

    }
    //m is rows, n = columns
    public static int totalPaths(int m, int n) {
        if (m <= 0 || n <= 0) return 0;
        int[][] dp = new int[m][n];

        for(int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        for(int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }

        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
