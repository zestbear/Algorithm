import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int[] num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        num = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            num[i] = i;
        }
        int func;
        int a, b;
        int num1 = -1;
        int num2 = -1;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            func = Integer.parseInt(st.nextToken());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            num1 = find(a);
            num2 = find(b);

            if (func == 0) {
                union(num1, num2);
            } else if (func == 1) {
                if (num1 == num2) {
                    sb.append("YES").append('\n');
                } else {
                    sb.append("NO").append('\n');
                }
            }
        }
        System.out.print(sb);
    }

    public static int find(int x) {
        if (num[x] == x) {
            return x;
        } else {
            return find(num[x]);
        }
    }

    public static void union(int x, int y) {
        int root_x = find(x);
        int root_y = find(y);

        num[root_y] = root_x;
    }
}