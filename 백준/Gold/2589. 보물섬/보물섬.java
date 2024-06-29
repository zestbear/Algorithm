import java.io.*;
import java.util.*;

class Main {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Node {
        int x;
        int y;
        int level;
        public Node(int x, int y, int level) {
            this.x = x;
            this.y = y;
            this.level = level;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String[][] arr = new String[n][m];

        for (int i = 0; i < n; i++) {
            String[] temp = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                arr[i][j] = temp[j];
            }
        }

        int max = 0;
        Queue<Node> queue;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j].equals("L")) {
                    queue = new LinkedList<>();
                    int maxHere = bfs(i, j, arr, queue);
                    if (maxHere > max) {
                        max = maxHere;
                    }
                }
            }
        }
        System.out.println(max);
    }

    public static int bfs(int sn, int sm, String[][] arr, Queue<Node> queue) {
        int max = 0;
        int[][] visit = new int[arr.length][arr[0].length];
        queue.add(new Node(sn, sm, 0));
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            visit[node.x][node.y] = 1;
            int level = node.level;
            int cnt = 0;
            for (int i = 0; i < 4; i++) {
                int dn = node.x + dx[i];
                int dm = node.y + dy[i];
                if (0 <= dn && dn < arr.length && 0 <= dm && dm < arr[0].length && arr[dn][dm].equals("L") && visit[dn][dm] == 0) {
                    visit[dn][dm] = 1;
                    queue.add(new Node(dn, dm, level + 1));
                } else {
                    cnt++;
                }
            }
            if (cnt == 4) {
                if (max < node.level) {
                    max = level;
                }
            }
        }
        return max;
    }
}