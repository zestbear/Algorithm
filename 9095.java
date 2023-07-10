
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner bf = new Scanner(System.in);
        int N = bf.nextInt();
        int n;
        for (int i = 0; i < N; i++) {
            n = bf.nextInt();
            int[] dp = new int[12];
            dp[0] = 1;
            dp[1] = 2;
            dp[2] = 4;
            for (int j = 3; j < n; j++) {
                dp[j] = dp[j - 3] + dp[j - 2] + dp[j - 1];
            }

            System.out.println(dp[n - 1]);
        }

    }
}
