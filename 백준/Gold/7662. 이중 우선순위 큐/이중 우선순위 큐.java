import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int k = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> map = new TreeMap<>();
            String fuc;
            int n;
            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                fuc = st.nextToken();
                n = Integer.parseInt(st.nextToken());

                if (fuc.equals("I")) {
                    map.put(n, map.getOrDefault(n, 0) + 1);
                } else if (fuc.equals("D")) {
                    if(map.isEmpty()) continue;
                    int rem;
                    if (n == 1) {
                        rem = map.lastKey();
                    } else {
                        rem = map.firstKey();
                    }

                    if (map.get(rem) == 1) {
                        map.remove(rem);
                    } else {
                        map.put(rem, map.get(rem) - 1);
                    }
                }
            }
            if (map.isEmpty()) {
                System.out.println("EMPTY");
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(map.lastKey()).append(" ").append(map.firstKey());
                System.out.println(sb.toString());
            }
        }
    }
}
