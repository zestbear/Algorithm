import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static Long mod = 10007L;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        Long[] dp = new Long[n + 1];
        if (n >= 1) {
            dp[1] = 1L;
            if (n >= 2) {
                dp[2] = 2L;
                if (n >= 3) {
                    for (int i = 3; i < n + 1; i++) {
                        dp[i] = (dp[i - 1] + dp[i - 2]) % mod;
                    }
                }
            }
        }
        System.out.println(dp[n] % mod);
        bf.close();
    }
}