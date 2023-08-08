import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] num;
    static int max = (int) -1e19;
    static int min = (int) 1e19;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        num = new int[N];
        int[] op = new int[4];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }

        int[] result = new int[2];
        result = DFS(num[0], 1, op);

        System.out.println(result[0]);
        System.out.println(result[1]);

        br.close();
    }

    public static int[] DFS(int ret, int idx, int[] op) {
        int[] result = new int[2];
        if (idx == num.length) {
            max = Math.max(max, ret);
            min = Math.min(min, ret);
        }

        if (op[0] > 0) {
            op[0] = op[0] - 1;
            DFS(ret + num[idx], idx + 1, op);
            op[0] = op[0] + 1;
        }
        if (op[1] > 0) {
            op[1] = op[1] - 1;
            DFS(ret - num[idx], idx + 1, op);
            op[1] = op[1] + 1;
        }
        if (op[2] > 0) {
            op[2] = op[2] - 1;
            DFS(ret * num[idx], idx + 1, op);
            op[2] = op[2] + 1;
        }
        if (op[3] > 0) {
            op[3] = op[3] - 1;
            DFS(ret / num[idx], idx + 1, op);
            op[3] = op[3] + 1;
        }

        result[0] = max;
        result[1] = min;
        return result;
    }

}