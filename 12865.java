import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] Weight = new int[N+1];
        int[] Value = new int[N+1];
        for(int i=1; i<N+1; i++){
           st = new StringTokenizer(bf.readLine());
            Weight[i] = Integer.parseInt(st.nextToken());
            Value[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[N + 1][K + 1];

        for (int k = 1; k <= K; k++) {
            for (int i = 1; i <= N; i++) {
                dp[i][k] = dp[i - 1][k];
                if (k - Weight[i] >= 0) {
                    dp[i][k] = Math.max(dp[i - 1][k], Value[i] + dp[i - 1][k - Weight[i]]);
                }
            }
        }


        System.out.println(dp[N][K]);
    }
}