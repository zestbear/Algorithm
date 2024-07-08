import java.io.*;
import java.util.*;

class Main {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Node {
        int x;
        int y;
        int dist;

        public Node(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    public static void bfs(int[][] arr, int[][] dist, int sx, int sy) {
        boolean[][] visit = new boolean[arr.length][arr[0].length];
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(sx, sy, 0));
        visit[sx][sy] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            visit[node.x][node.y] = true;

            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if (!(0 <= nx && nx < arr.length && 0 <= ny && ny < arr[0].length) || visit[nx][ny]) continue;
                if (arr[nx][ny] == 0) continue;

                queue.add(new Node(nx, ny, node.dist + 1));
                dist[nx][ny] = node.dist + 1;
                visit[nx][ny] = true;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];
        int[][] dist = new int[n][m];
        int sx = 0;
        int sy = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 0) {
                    dist[i][j] = 0;
                } else if (arr[i][j] == 1) {
                    dist[i][j] = -1;
                } else {
                    sx = i;
                    sy = j;
                }
            }
        }

        bfs(arr, dist, sx, sy);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }
    }
}