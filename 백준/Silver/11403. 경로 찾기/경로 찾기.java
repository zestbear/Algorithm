import java.io.*;
import java.util.*;

class Main {

    public static void bfs(ArrayList<ArrayList<Integer>> list, int start, int[][] result) {
        int length = list.size();
        boolean[] visit = new boolean[length];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int next : list.get(node)) {
                if (!visit[next]) {
                    queue.add(next);
                    visit[next] = true;
                    result[start][next] = 1;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                if (st.nextToken().equals("1")) list.get(i).add(j);
            }
        }

        int[][] result = new int[N][N];

        for (int i = 0; i < N; i++) {
            bfs(list, i, result);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
