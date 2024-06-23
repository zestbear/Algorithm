import java.io.*;
import java.util.*;

class Main {

    public static int toInteger(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        int[] dp = new int[n];
        dp[0] = toInteger(input[0]);
        int max = dp[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1] + toInteger(input[i]), toInteger(input[i]));
            max = Math.max(dp[i], max);
        }
        System.out.println(max);
    }

}