import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] result = new int[n + 1];
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            list.add(new ArrayList<>());
        }
        boolean[] visited = new boolean[n + 1];
        StringTokenizer st;
        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            list.get(num1).add(num2);
            list.get(num2).add(num1);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int next : list.get(current)) {
                if (visited[next]) {
                    continue;
                }
                visited[next] = true;
                queue.add(next);
                result[next] = current;
            }
        }

        for (int i = 2; i <= n; i++) {
            System.out.println(result[i]);
        }
    }
}
