import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        int N, M, K;
        int[][] arr;
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            arr = new int[N][M];
            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                arr[x][y] = 1;
            }

            int cnt = 0;
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (arr[j][k] == 1) {
                        cnt++;
                        DFS(arr, j, k);
                    }
                }
            }
            sb.append(cnt).append('\n');
        }

        System.out.println(sb);
    }

    public static void DFS(int[][] arr, int row, int col) {
        arr[row][col] = 0;
        for (int i = 0; i < 4; i++) {
            int nx = row + dx[i];
            int ny = col + dy[i];

            if (nx >= 0 && nx < arr.length && ny >= 0 && ny < arr[0].length) {
                if (arr[nx][ny] == 1) {
                    DFS(arr, nx, ny);
                }
            }
        }
    }
}