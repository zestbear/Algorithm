import java.util.*;
import java.io.*;

class Main {

    static class Node {
        int x;
        int y;
        int z;
        int day;
        public Node(int x, int y, int z, int day) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.day = day;
        }
    }

    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};

    public static Boolean check(int[][][] tomato) {
        for (int i = 0; i < tomato.length; i++) {
            for (int j = 0; j < tomato[0].length; j++) {
                for (int k = 0; k < tomato[0][0].length; k++) {
                    if (tomato[i][j][k] == 0) return false;
                }
            }
        }
        return true;
    }

    public static int bfs(int[][][] tomato) {
        int max = 0;
        Queue<Node> queue = new LinkedList<>();
        for (int i = 0; i < tomato.length; i++) {
            for (int j = 0; j < tomato[0].length; j++) {
                for (int k = 0; k < tomato[0][0].length; k++) {
                    if (tomato[i][j][k] == 1) {
                        queue.add(new Node(i, j, k, 0));
                    }
                }
            }
        }

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            max = node.day;

            for (int i = 0; i < 6; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                int nz = node.z + dz[i];
                if (isValid(nx, ny, nz, tomato) && tomato[nx][ny][nz] == 0) {
                    tomato[nx][ny][nz] = 1;
                    queue.add(new Node(nx, ny, nz, node.day + 1));
                }
            }
        }

        return max;
    }

    public static Boolean isValid(int x, int y, int z, int[][][] arr) {
        return 0 <= x && x < arr.length && 0 <= y && y < arr[0].length && 0 <= z && z < arr[0][0].length;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int[][][] tomato = new int[H][M][N];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < M; j++) {
                String[] temp = br.readLine().split(" ");
                for (int k = 0; k < N; k++) {
                    tomato[i][j][k] = Integer.parseInt(temp[k]);
                }
            }
        }

        if (check(tomato)) {
            System.out.println(0); // initial check
            return;
        }

        int max = bfs(tomato);

        if(!check(tomato)) System.out.println(-1);
        else System.out.println(max);
    }
}
