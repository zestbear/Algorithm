import java.io.*;
import java.util.*;

class Main {

    static int[] dx = {-1, -1, -1, 1, 1, 1, 0, 0};
    static int[] dy = {-1, 0, 1, -1, 0, 1, 1, -1};

    public static int[][] dfs(int[][] arr, int[][] visit, int x, int y) {
        visit[x][y] = 1;
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (0 <= nx && nx < arr.length && 0 <= ny && ny < arr[0].length) {
                if (arr[nx][ny] == 1 && visit[nx][ny] != 1) {
                    dfs(arr, visit, nx, ny);
                }
            }
        }
        return visit;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            if (n == 0 && m == 0) { // 종료조건
                break;
            }

            int[][] arr = new int[n][m];
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    arr[j][i] = Integer.parseInt(st.nextToken());
                }
            }

            int count = 0;
            int[][] visit = new int[n][m];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    visit[j][i] = 0;
                }
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (arr[j][i] == 1 && visit[j][i] == 0) {
                        dfs(arr, visit, j, i);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }
}