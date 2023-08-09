import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static long pow(int A, int B, int C) {
        if (B == 0) {
            return 1;
        }
        long ret = pow(A, B / 2, C);
        if (B % 2 == 0) {
            return ret * ret % C;
        } else {
            return (ret * ret % C) * A % C;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        System.out.println(pow(A, B, C));
    }
}