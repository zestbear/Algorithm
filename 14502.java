import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n;
    static int m;
    static int max = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        wall(arr, 0, 0, 0);

        System.out.println(max);
    }

    public static int execute(int[][] arr) {
        int[][] copyArr = new int[n][m];

        for (int i = 0; i < n; i++) {
            copyArr[i] = Arrays.copyOf(arr[i], m);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (copyArr[i][j] == 2) {
                    infect(copyArr, i, j);
                }
            }
        }

        return count(copyArr);
    }

    public static void wall(int[][] arr, int row, int col, int cnt) {
        if (cnt == 3) {
            int temp = execute(arr);
            if (temp > max) {
                max = temp;
            }
        } else {
            for (int i = row; i < n; i++) {
                for (int j = col; j < m; j++) {
                    if (arr[i][j] == 0) {
                        arr[i][j] = 1; //벽 설치
                        wall(arr, i, j + 1, cnt + 1);
                        arr[i][j] = 0; //백트래킹
                    }
                }
                col = 0;
            }
        }
    }

    public static int[][] infect(int[][] arr, int row, int col) {
        for (int k = 0; k < 4; k++) {
            int nx = row + dx[k];
            int ny = col + dy[k];
            if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                if (arr[nx][ny] == 0) {
                    arr[nx][ny] = 2;
                    infect(arr, nx, ny);
                }
            }
        }
        return arr;
    }

    public static int count(int[][] arr) {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

}