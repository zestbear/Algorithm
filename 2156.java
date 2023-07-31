import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        int[] input = new int[n];
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(bf.readLine());
        }

        int[] dp = new int[n];
        dp[0] = input[0];
        if (n > 1) {
            dp[1] = input[0] + input[1];
            if (n > 2) {
                dp[2] = Math.max(input[0] + input[1], Math.max(input[0] + input[2], input[1] + input[2]));
                if (n > 3) {
                    for (int i = 3; i < n; i++) {
                        dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + input[i], input[i - 1] + input[i] + dp[i - 3]));
                    }
                }
            }
        }

        System.out.print(dp[n - 1]);
        bf.close();
    }
}