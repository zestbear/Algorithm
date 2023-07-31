import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(bf.readLine());
        int[][] num = new int[500][500];
        int[][] dp = new int[500][500];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            int idx = 0;
            while (st.hasMoreTokens()) {
                num[i][idx] = Integer.parseInt(st.nextToken());
                idx++;
            }
        }

        dp[0][0] = num[0][0];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + num[i][j];
                } else if (i == j) {
                    dp[i][j] = dp[i - 1][j - 1] + num[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + num[i][j];
                }
            }
        }

        int max = dp[n - 1][0];
        for (int i = 0; i < n; i++) {
            if (dp[n - 1][i] > max) {
                max = dp[n - 1][i];
            }
        }

        System.out.println(max);
    }
}