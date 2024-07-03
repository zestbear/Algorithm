import java.io.*;
import java.util.*;

class Main {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Node {
        int x;
        int y;
        int cost;
        boolean des;

        public Node(int x, int y, int cost, boolean des) {
            this.x = x;
            this.y = y;
            this.cost = cost;
            this.des = des;
        }
    }

    public static int bfs(int[][] arr) {
        boolean[][] visit = new boolean[arr.length][arr[0].length];
        boolean[][] visitDes = new boolean[arr.length][arr[0].length];
        Queue<Node> queue = new LinkedList<>();
        visit[0][0] = true;
        queue.add(new Node(0, 0, 1, false));
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if(node.x == arr.length - 1 && node.y == arr[0].length - 1) return node.cost;
            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if(isValid(arr, nx, ny)) continue;

                if (arr[nx][ny] == 0) { // 벽이 아니면
                    if (node.des && !visitDes[nx][ny]) { // 벽을 부순 적이 있다면
                        visitDes[nx][ny] = true;
                        queue.add(new Node(nx, ny, node.cost + 1, true));
                    } else if(!node.des && !visit[nx][ny]) { // 벽을 부순 적이 없다면
                        visit[nx][ny] = true;
                        queue.add(new Node(nx, ny, node.cost + 1, false));
                    }
                } else { // 벽이면
                    if (!node.des) { // 벽을 부순 적이 없다면
                        visitDes[nx][ny] = true;
                        queue.add(new Node(nx, ny, node.cost + 1, true));
                    }
                }
            }
        }
        return -1;
    }

    public static boolean isValid(int[][] arr, int x, int y) {
        return !(0 <= x && x < arr.length && 0 <= y && y < arr[0].length);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            String[] temp = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(temp[j]);
            }
        }

        System.out.println(bfs(arr));
    }
}