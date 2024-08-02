import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Set<String> forN = new HashSet<>();
        ArrayList<String> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            forN.add(br.readLine().trim());
        }

        for (int i = 0; i < m; i++) {
            String forM = br.readLine().trim();
            if (forN.contains(forM)) {
                result.add(forM);
            }
        }

        Collections.sort(result);
        sb.append(result.size()).append("\n");
        for (String mem : result) {
            sb.append(mem).append("\n");
        }

        System.out.print(sb.toString());
    }
}