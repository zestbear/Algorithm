class Solution {

    int dm;
    int dn;

    public int solution(int m, int n, int[][] puddles) {
        dm = m;
        dn = n;
        int[][] dp = new int[m][n];
        dp[0][0] = 1;

        boolean[][] pud = new boolean[m][n];
        for (int i = 0; i < puddles.length; i++) {
            pud[puddles[i][0] - 1][puddles[i][1] - 1] = true;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;
                if (pud[i][j]) {
                    dp[i][j] = 0;
                    continue;
                }

                int nx = 0;
                int ny = 0;
                if (i > 0) nx = dp[i - 1][j];
                if (j > 0) ny = dp[i][j - 1];

                dp[i][j] = (nx + ny) % 1000000007;
            }
        }

        return dp[m - 1][n - 1];
    }
}
