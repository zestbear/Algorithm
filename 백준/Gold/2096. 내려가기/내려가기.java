import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] input = new int[n][3];
        int[][] maxArr = new int[n][3];
        int[][] minArr = new int[n][3];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                input[i][j] = Integer.parseInt(st.nextToken());
                if (i == 0) {
                    maxArr[i][j] = input[i][j];
                    minArr[i][j] = input[i][j];
                }
            }
        }

        for (int i = 1; i < n; i++) {
            maxArr[i][0] = Math.max(maxArr[i - 1][0], maxArr[i - 1][1]) + input[i][0];
            maxArr[i][1] = Math.max(Math.max(maxArr[i - 1][0], maxArr[i - 1][1]), maxArr[i - 1][2]) + input[i][1];
            maxArr[i][2] = Math.max(maxArr[i - 1][1], maxArr[i - 1][2]) + input[i][2];

            minArr[i][0] = Math.min(minArr[i - 1][0], minArr[i - 1][1]) + input[i][0];
            minArr[i][1] = Math.min(Math.min(minArr[i - 1][0], minArr[i - 1][1]), minArr[i - 1][2]) + input[i][1];
            minArr[i][2] = Math.min(minArr[i - 1][1], minArr[i - 1][2]) + input[i][2];
        }

        int max = Math.max(Math.max(maxArr[n - 1][0], maxArr[n - 1][1]), maxArr[n - 1][2]);
        int min = Math.min(Math.min(minArr[n - 1][0], minArr[n - 1][1]), minArr[n - 1][2]);

        System.out.println(max + " " + min);
    }
}
