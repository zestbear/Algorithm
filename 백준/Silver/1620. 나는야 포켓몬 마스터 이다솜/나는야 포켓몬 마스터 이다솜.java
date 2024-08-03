import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<Integer, String> numToStr = new HashMap<>();
        Map<String, Integer> strToNum = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String name = br.readLine().trim();
            numToStr.put(i + 1, name);
            strToNum.put(name, i + 1);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            String input = br.readLine().trim();
            char first = input.charAt(0);

            if (Character.isDigit(first)) {
                sb.append(numToStr.get(Integer.parseInt(input))).append("\n");
            } else {
                sb.append(strToNum.get(input)).append("\n");
            }
        }

        System.out.print(sb.toString());
    }
}