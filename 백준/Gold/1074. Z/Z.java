import java.io.*;
import java.util.*;

class Main {

    public static int check(int n, int r, int c, int sum) {
        if (n == 0) {
            return sum;
        } else {
            int len = (int) Math.pow(2, n);
            boolean br = r >= (int) Math.pow(2, n - 1);
            boolean bc = c >= (int) Math.pow(2, n - 1);

            if (!br && !bc) { // br == false, bc == false
                return check(n - 1, r, c, sum);
            } else if (!br && bc) { // br == false, bc == true
                return check(n - 1, r, c - (int) Math.pow(2, n - 1), sum + len * len / 4);
            } else if (br && !bc) { // br == true, bc == false
                return check(n - 1, r - (int) Math.pow(2, n - 1), c, sum + len * len / 4 * 2);
            } else { // br == true, bc == true
                return check(n - 1, r - (int) Math.pow(2, n - 1), c - (int) Math.pow(2, n - 1), sum + len * len / 4 * 3);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        System.out.println(check(n, r, c, 0));
    }
}