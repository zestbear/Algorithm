import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] arr = new int[25][25];
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[] groupCounts = new int[625];

    private static void DFS(int row, int col, int idx) {
        arr[row][col] = -1;
        groupCounts[idx - 1]++;

        for (int i = 0; i < 4; i++) {
            int nx = row + dx[i];
            int ny = col + dy[i];
            if (nx >= 0 && ny >= 0 && nx < 25 && ny < 25 && arr[nx][ny] == 1) {
                DFS(nx, ny, idx);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            String str = bf.readLine();
            String[] strs = str.split("");
            for (int j = 0; j < strs.length; j++) {
                arr[i][j] = Integer.parseInt(strs[j]);
            }
        }

        int idx = 1;
        for (int i = 0; i < 25; i++) {
            for (int j = 0; j < 25; j++) {
                if (arr[i][j] == 1) {
                    DFS(i, j, idx);
                    idx++;
                }
            }
        }

        int[] result = Arrays.stream(groupCounts).filter(count -> count > 0).sorted().toArray();
        System.out.println(result.length);
        for (int count : result) {
            System.out.println(count);
        }
    }
}
