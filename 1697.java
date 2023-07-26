import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import static java.lang.Math.pow;

public class Main {

    static int idx = 1;
    static Queue<Integer> queue = new LinkedList<>();

    public static int BFS(int K) {
        int cnt = 0;
        //int ret = 0;
        while (!queue.isEmpty()) {
            int n = queue.poll();
            if (n > 0) {
                if (n - 1 == K || n + 1 == K || 2 * n == K) {
                    break;
                } else {
                    queue.add(n - 1);
                    queue.add(n + 1);
                    queue.add(2 * n);
                    cnt++;
                }
            }

            for (int i = 0; i <= 10; i ++) {
                if (cnt == pow(3, i)) {
                    idx++;
                }
            }
        }

        return idx;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        queue.add(N);
        int str = BFS(K);

        System.out.println(str);

    }
}