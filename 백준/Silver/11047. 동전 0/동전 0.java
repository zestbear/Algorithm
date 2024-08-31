import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<Integer> values = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            values.add(Integer.parseInt(br.readLine()));
        }
        Collections.reverse(values);

        int cnt = 0;
        while (k != 0) {
            for (Integer value : values) {
                if (k >= value) {
                    k -= value;
                    cnt++;
                    break;
                }
            }
        }

        System.out.println(cnt);
    }
}