import java.io.*;
import java.util.*;

class Main {

    static int n;
    static int m;
    static int[] len;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        len = new int[n];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            len[i] = Integer.parseInt(st.nextToken());
            if(max < len[i]) max = len[i];
        }

        int start = 0;
        int end = max;

        System.out.println(dnc(start, end));
    }

    public static int dnc(int start, int end) {
        int result = 0;
        while (start <= end) {
            int mid = (start + end) / 2;
            long sum = cut(mid);
            if (sum >= m) {
                result = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return result;
    }

    public static long cut(int c) {
        long sum = 0;
        for (int l : len) {
            if (l > c) {
                sum += l - c;
            }
        }
        return sum;
    }
}