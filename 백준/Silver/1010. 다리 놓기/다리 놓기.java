import java.io.*;

class Main {

    public static int[][] combine() {
        int[][] dp = new int[30][30];

        for (int i = 0; i < 30; i++) {
            dp[i][i] = 1;
            dp[i][0] = 1;
        }

        for (int i = 0; i < 30; i++) {
            for (int j = 1; j < i + 1; j++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
        }

        return dp;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[][] dp = combine();

        for (int i = 0; i < T; i++) {
            String[] input;
            input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);

            System.out.println(dp[m][n]);
        }
    }

}