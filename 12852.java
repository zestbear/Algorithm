import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Queue;

import static java.lang.Math.min;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];
        ArrayList<Integer>[] list = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }

        dp[1] = 0;
        list[1].add(1);
        if (N > 1) {
            dp[2] = 1;
            list[2] = new ArrayList<>();
            list[2].add(1);
            list[2].add(2);
            if (N > 2) {
                dp[3] = 1;
                list[3] = new ArrayList<>();
                list[3].add(1);
                list[3].add(3);
                if (N > 3) {
                    for (int i = 4; i < N + 1; i++) {
                        if (i % 3 == 0 && i % 2 != 0) {
                            dp[i] = min(dp[i - 1], dp[i / 3]) + 1;
                            if (dp[i] - 1 == dp[i - 1]) {
                                list[i] = new ArrayList<>();
                                list[i].addAll(list[i - 1]);
                            } else if (dp[i] - 1 == dp[i / 3]) {
                                list[i] = new ArrayList<>();
                                list[i].addAll(list[i / 3]);
                            }
                        } else if (i % 2 == 0 && i % 3 != 0) {
                            dp[i] = min(dp[i - 1], dp[i / 2]) + 1;
                            if (dp[i] - 1 == dp[i - 1]) {
                                list[i] = new ArrayList<>();
                                list[i].addAll(list[i - 1]);
                            } else if (dp[i] - 1 == dp[i / 2]) {
                                list[i] = new ArrayList<>();
                                list[i].addAll(list[i / 2]);
                            }
                        } else if (i % 6 == 0) {
                            dp[i] = min(min(dp[i / 2], dp[i / 3]), dp[i - 1]) + 1;
                            if (dp[i] - 1 == dp[i - 1]) {
                                list[i] = new ArrayList<>();
                                list[i].addAll(list[i - 1]);
                            } else if (dp[i] == dp[i / 3] + 1) {
                                list[i] = new ArrayList<>();
                                list[i].addAll(list[i / 3]);
                            } else if (dp[i] - 1 == dp[i / 2]) {
                                list[i] = new ArrayList<>();
                                list[i].addAll(list[i / 2]);
                            }
                        } else {
                            dp[i] = dp[i - 1] + 1;
                            list[i] = new ArrayList<>();
                            list[i].addAll(list[i - 1]);
                        }
                        list[i].add(i);
                    }
                }
            }
        }

        System.out.println(dp[N]);
        list[N].sort(Comparator.reverseOrder());
        for (int i = 0; i < list[N].size(); i++) {
            System.out.print(list[N].get(i) + " ");
        }
    }
}